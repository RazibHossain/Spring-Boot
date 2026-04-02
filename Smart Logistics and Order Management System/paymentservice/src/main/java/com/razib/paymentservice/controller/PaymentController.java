package com.razib.paymentservice.controller;

import com.razib.paymentservice.dto.PaymentRequestDTO;
import com.razib.paymentservice.entity.Payment;
import com.razib.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Payment processPayment(@RequestBody PaymentRequestDTO request) {
        return paymentService.processPayment(request);
    }
}