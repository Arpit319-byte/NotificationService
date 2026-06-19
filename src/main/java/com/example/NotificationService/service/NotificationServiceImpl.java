package com.example.NotificationService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.NotificationService.entity.Notification;
import com.example.NotificationService.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements INotificationService{
    
    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository){
        this.notificationRepository=notificationRepository;
    }

    @Override
    public Notification createNotificaton(Notification notificaton) {
        
        Notification newNotification=notificationRepository.save(notificaton);
        return newNotification;
    }

    @Override
    public Notification getNotificationById(Long id) {
        
        Notification notification=notificationRepository
        return notification;
    }



    @Override
    public List<Notification> getNotificationByUserId(Long userId) {
        
        List<Notification> notificationList= notificationRepository.findByUserId(userId)
                                             .orElse(null);

        return notificationList;
    }

    @Override
    public Notification retryNotificationById(Long notificationId,Notification notification) {
        
        Notification newNotification= notificationRepository.save(notification);
        return newNotification;

    }


}
