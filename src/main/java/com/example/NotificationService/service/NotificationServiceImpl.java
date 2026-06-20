package com.example.NotificationService.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.NotificationService.entity.Notification;
import com.example.NotificationService.entity.Status;
import com.example.NotificationService.exception.InvalidNotificationStateException;
import com.example.NotificationService.exception.ResourceNotFoundException;
import com.example.NotificationService.repository.NotificationRepository;

import jakarta.transaction.Transactional;

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
        
        Notification notification=notificationRepository.findById(id)
                                  .orElseThrow(()-> new RuntimeException("Notification not found wiht id: "+id));

        return notification;
    }



    @Override
    public List<Notification> getNotificationByUserId(Long userId) {
        
        List<Notification> notificationList= notificationRepository.findByUserId(userId);
                                            
        return notificationList;
    }

    @Override
    @Transactional
    public Notification retryNotificationById(Long notificationId){
        
        Notification notification=notificationRepository.findById(notificationId)
                                  .orElseThrow(()->new ResourceNotFoundException("Notification is not found with id: "+notificationId));

        
        if(notification.getStatus() != Status.FAILED){
            throw new InvalidNotificationStateException("Only the FAILED notifcation can be retired. Current status of notification: "+ notification.getStatus());
        }

        notification.setStatus(Status.PENDING);
        Notification saved = notificationRepository.save(notification);
        return saved;

    }


}
