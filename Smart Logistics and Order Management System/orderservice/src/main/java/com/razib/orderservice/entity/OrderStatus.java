package com.razib.orderservice.entity;

public enum OrderStatus {
    CREATED,
    PROCESSING,
    CONFIRMED,
    SHIPPED,
    DELIVERED,
    CANCELLED,

    PAID,

    FAILED
}