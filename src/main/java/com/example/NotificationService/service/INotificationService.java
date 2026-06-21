package com.example.NotificationService.service;

import java.util.List;
import com.example.NotificationService.dto.notification.CreateNotificationRequest;
import com.example.NotificationService.dto.notification.NotificationResponse;

public interface INotificationService {

    NotificationResponse createNotificaton(CreateNotificationRequest request);
    NotificationResponse getNotificationById(Long id);
    List<NotificationResponse> getNotificationByUserId(Long userId);
    NotificationResponse retryNotificationById(Long notificationId);

}
