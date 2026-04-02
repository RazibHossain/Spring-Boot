package com.razib.orderservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
    private Long orderId;
    private Double amount;
}