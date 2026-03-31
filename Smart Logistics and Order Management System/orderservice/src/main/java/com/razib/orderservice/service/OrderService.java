package com.razib.orderservice.service;

// OrderService.java

import com.razib.orderservice.dto.OrderItemResponseDTO;
import com.razib.orderservice.dto.OrderRequestDTO;
import com.razib.orderservice.dto.OrderResponseDTO;
import com.razib.orderservice.entity.Order;
import com.razib.orderservice.entity.OrderItem;
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

    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequest) {
        // Create new order with CREATED status
        Order order = new Order(orderRequest.getCustomerName(), orderRequest.getCustomerEmail());

        // Add items to order
        for (var itemDTO : orderRequest.getItems()) {
            OrderItem item = new OrderItem(
                    itemDTO.getProductName(),
                    itemDTO.getProductCode(),
                    itemDTO.getQuantity(),
                    itemDTO.getUnitPrice()
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
        BigDecimal totalAmount = order.getItems().stream()
                .map(OrderItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        response.setTotalAmount(totalAmount);

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
}