package com.alkoscode.notification.consumer;

import com.alkoscode.clients.notification.model.NotificationRequest;
import com.alkoscode.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public record NotificationConsumer(NotificationService notificationService) {

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consume(final NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
