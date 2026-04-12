package com.razib.orderservice.fallback;


import com.razib.orderservice.dto.PaymentRequestDTO;
import com.razib.orderservice.dto.PaymentResponseDTO;
import com.razib.orderservice.feignclient.PaymentClient;
import org.springframework.stereotype.Component;

@Component
public class PaymentClientFallback implements PaymentClient {

    @Override
    public PaymentResponseDTO pay(PaymentRequestDTO request) {

        // fallback response when payment service fails
        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setStatus("FAILED");
        response.setMessage("Payment service unavailable. Try later.");

        return response;
    }
}