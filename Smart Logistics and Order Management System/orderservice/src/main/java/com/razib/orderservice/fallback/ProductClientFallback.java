package com.razib.orderservice.fallback;


import com.razib.orderservice.dto.PaymentRequestDTO;
import com.razib.orderservice.dto.PaymentResponseDTO;
import com.razib.orderservice.feignclient.PaymentClient;
import com.razib.orderservice.feignclient.ProductServiceClient;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFallback implements ProductServiceClient {


    @Override
    public Integer checkStock(Integer productId) {
        return -1;
    }
}