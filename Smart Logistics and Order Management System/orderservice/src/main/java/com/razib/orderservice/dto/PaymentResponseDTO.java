package com.razib.orderservice.dto;

import lombok.Data;

@Data
public class PaymentResponseDTO {
    private Long id;
    private Long orderId;
    private Double amount;
    private String status;
    private String transactionId;
    private String message;
}