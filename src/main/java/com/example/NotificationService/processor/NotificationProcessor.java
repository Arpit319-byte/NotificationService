package com.example.NotificationService.processor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.NotificationService.entity.Notification;
import com.example.NotificationService.entity.Status;
import com.example.NotificationService.repository.NotificationRepository;

@Service
public class NotificationProcessor {

    NotificationRepository notificationRepository;

    public NotificationProcessor(NotificationRepository notificationRepository){
        this.notificationRepository=notificationRepository;
    }

    @Transactional
    public void processPendingNotification(){
           
        List<Notification> pending=notificationRepository.findByStatus(Status.PENDING);

        for(Notification notification: pending){
            process(notification);
        }
    }
    
}
