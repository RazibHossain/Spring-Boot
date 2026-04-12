package com.razib.orderservice.service;

// OrderService.java

import com.razib.orderservice.dto.*;
import com.razib.orderservice.entity.Order;
import com.razib.orderservice.entity.OrderItem;
import com.razib.orderservice.entity.OrderStatus;
import com.razib.orderservice.feignclient.PaymentClient;
import com.razib.orderservice.feignclient.ProductServiceClient;
import com.razib.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    ProductServiceClient productClient;

    @Autowired
    PaymentClient paymentClient;

    public Order createOrder(OrderRequestDTO request) {

        // 🔹 Validate stock (inter-service call)
        for (OrderItemRequestDTO item : request.getItems()) {
            Integer stock = productClient.checkStock(item.getProductId()); // assuming productId exists

            if (stock == null || stock < item.getQuantity()) {
                throw new RuntimeException("Product ID " + item.getProductId() + " is out of stock");
            }
        }

        // 🔹 Build Order
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setCustomerEmail(request.getCustomerEmail());
        order.setStatus(OrderStatus.CREATED);
//        order.setCreatedAt(LocalDateTime.now());

        // 🔹 Map OrderItems
        List<OrderItem> orderItems = request.getItems().stream().map(itemDTO -> {
            OrderItem item = new OrderItem();
            item.setProductId(itemDTO.getProductId());   // IMPORTANT
            item.setQuantity(itemDTO.getQuantity());
//            item.setUnitPrice(itemDTO.getUnitPrice());
            item.setOrder(order); // set relation
            return item;
        }).toList();

        order.setItems(orderItems);

        // 🔹 Save Order
        return orderRepository.save(order);
    }

    @Transactional
    public OrderResponseDTO createOrderLocal(OrderRequestDTO orderRequest) {
        // Create new order with CREATED status
        Order order = new Order(orderRequest.getCustomerName(), orderRequest.getCustomerEmail());

        // Add items to order
        for (var itemDTO : orderRequest.getItems()) {
            OrderItem item = new OrderItem(
                    itemDTO.getProductName(),
                    itemDTO.getProductCode(),
                    itemDTO.getQuantity(),
                    itemDTO.getUnitPrice(),
                    itemDTO.getProductId()
            );
            order.addItem(item);
        }

        // Save order
        Order savedOrder = orderRepository.save(order);

        // Convert to response DTO
        return convertToResponseDTO(savedOrder);
    }

    public OrderResponseDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return convertToResponseDTO(order);
    }

    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private OrderResponseDTO convertToResponseDTO(Order order) {
        OrderResponseDTO response = new OrderResponseDTO();
        response.setId(order.getId());
        response.setCustomerName(order.getCustomerName());
        response.setCustomerEmail(order.getCustomerEmail());
        response.setOrderDate(order.getOrderDate());
        response.setStatus(order.getStatus());

        // Calculate total amount
//        BigDecimal totalAmount = order.getItems().stream()
//                .map(OrderItem::getSubtotal)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//        response.setTotalAmount(totalAmount);
        // Calculate total amount
        BigDecimal totalAmount = BigDecimal.ZERO;

        // Convert items
        response.setItems(order.getItems().stream()
                .map(this::convertItemToResponseDTO)
                .collect(Collectors.toList()));

        return response;
    }

    private OrderItemResponseDTO convertItemToResponseDTO(OrderItem item) {
        OrderItemResponseDTO response = new OrderItemResponseDTO();
        response.setId(item.getId());
        response.setProductName(item.getProductName());
        response.setProductCode(item.getProductCode());
        response.setQuantity(item.getQuantity());
        response.setUnitPrice(item.getUnitPrice());
        response.setSubtotal(item.getSubtotal());
        return response;
    }

    // 🔥 Separate payment API
    public PaymentResponseDTO payOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Prevent double payment
        if ("PAID".equals(order.getStatus())) {
            throw new RuntimeException("Order already paid");
        }

        // 🔹 Calculate total
        double totalAmount =10;

        // 🔹 Call Payment Service
        PaymentRequestDTO request =
                new PaymentRequestDTO(order.getId(), totalAmount);

        PaymentResponseDTO response =
                paymentClient.pay(request);

        // 🔹 Update status
        if ("SUCCESS".equalsIgnoreCase(response.getStatus())) {
            order.setStatus(OrderStatus.PAID);
        } else {
            order.setStatus(OrderStatus.FAILED);
        }

         orderRepository.save(order);
        return response;
    }
}