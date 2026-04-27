package com.razib.orderservice.kafka;

import com.razib.orderservice.event.OrderPaidEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventProducer {

    private final KafkaTemplate<String, OrderPaidEvent> kafkaTemplate;

    public void sendOrderPaidEvent(OrderPaidEvent event) {
        kafkaTemplate.send("order-paid-topic", event);
    }
}