package com.razib.paymentservice.service;

import com.razib.paymentservice.dto.PaymentRequestDTO;
import com.razib.paymentservice.entity.Payment;
import com.razib.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment processPayment(PaymentRequestDTO request) {

        // 🔥 Simulate payment (always success)
        Payment payment = Payment.builder()
                .orderId(request.getOrderId())
                .amount(request.getAmount())
                .status("SUCCESS")
                .transactionId(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .build();

        return paymentRepository.save(payment);
    }
}