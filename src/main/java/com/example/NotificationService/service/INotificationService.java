package com.example.NotificationService.service;

import java.util.List;
import com.example.NotificationService.entity.Notification;

public interface INotificationService {
    
    public Notification createNotificaton(Notification notificaton);
    public Notification getNotificationById(Long id);
    public List<Notification> getNotificationByUserId(Long userId);
    public Notification retryNotificationById(Long notificationId,Notification notification);

}
