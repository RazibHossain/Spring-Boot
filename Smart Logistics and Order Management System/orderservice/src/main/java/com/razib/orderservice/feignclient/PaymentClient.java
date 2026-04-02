package com.razib.orderservice.feignclient;

import com.razib.orderservice.dto.PaymentRequestDTO;
import com.razib.orderservice.dto.PaymentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paymentservice", url = "http://localhost:9030")
public interface PaymentClient {

    @PostMapping("/payments")
    PaymentResponseDTO pay(@RequestBody PaymentRequestDTO request);
}