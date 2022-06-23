package com.alkoscode.notification.service;

import com.alkoscode.clients.notification.model.NotificationRequest;
import com.alkoscode.notification.model.Notification;
import com.alkoscode.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {
    public void sendNotification(final NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("Alkoscode")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}
