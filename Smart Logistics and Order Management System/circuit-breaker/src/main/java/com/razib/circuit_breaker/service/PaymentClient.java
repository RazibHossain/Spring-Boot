package com.razib.circuit_breaker.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class PaymentClient {

    private final RestTemplate restTemplate;

    public PaymentClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackPayment")
    @Retry(name = "paymentService")
    @TimeLimiter(name = "paymentService")
    public CompletableFuture<String> callPaymentService() {

        return CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject("http://payment-service/pay", String.class)
        );
    }

    public CompletableFuture<String> fallbackPayment(Throwable ex) {
        return CompletableFuture.completedFuture(
                "Payment service is down. Please try later."
        );
    }
}