package com.alkoscode.clients.notification;

import com.alkoscode.clients.notification.model.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping(path = "api/v1/notifications")
    void sendNotification(NotificationRequest notificationRequest);
}
