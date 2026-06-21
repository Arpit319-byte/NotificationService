package com.example.NotificationService.mapper;

import java.util.List;
import com.example.NotificationService.dto.notification.CreateNotificationRequest;
import com.example.NotificationService.dto.notification.NotificationResponse;
import com.example.NotificationService.entity.Notification;

public final class NotificationMapper {

    private NotificationMapper() {
    }

    public static Notification toEntity(CreateNotificationRequest request) {
        Notification notification = new Notification();
        notification.setUserId(request.getUserId());
        notification.setChannel(request.getChannel());
        notification.setSubject(request.getSubject());
        notification.setMessage(request.getMessage());
        return notification;
    }

    public static NotificationResponse toResponse(Notification notification) {
        NotificationResponse response = new NotificationResponse();
        response.setId(notification.getId());
        response.setUserId(notification.getUserId());
        response.setChannel(notification.getChannel());
        response.setSubject(notification.getSubject());
        response.setMessage(notification.getMessage());
        response.setStatus(notification.getStatus());
        response.setCreatedAt(notification.getCreatedAt());
        response.setUpdatedAt(notification.getUpdatedAt());
        return response;
    }

    public static List<NotificationResponse> toResponseList(List<Notification> notifications) {
        return notifications.stream().map(NotificationMapper::toResponse).toList();
    }

}
