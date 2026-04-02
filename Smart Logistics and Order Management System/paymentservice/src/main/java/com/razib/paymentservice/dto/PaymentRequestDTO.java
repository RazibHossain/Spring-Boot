package com.razib.paymentservice.dto;


import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class PaymentRequestDTO {

    @NotNull
    private Long orderId;

    @NotNull
    private Double amount;
}