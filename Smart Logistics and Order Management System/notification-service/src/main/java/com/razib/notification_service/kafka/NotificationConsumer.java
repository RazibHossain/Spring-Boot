package com.razib.notification_service.kafka;

import com.razib.notification_service.event.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationConsumer {

    @KafkaListener(topics = "order-paid-topic", groupId = "notification-group")
    public void consume(OrderPaidEvent event) {

        log.info("Received event: {}", event);

        // 👉 Call email service
        sendEmail(event);
    }

    private void sendEmail(OrderPaidEvent event) {
        System.out.println("📧 Sending email to: " + event.getCustomerEmail());
        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("Amount: " + event.getAmount());
    }
}