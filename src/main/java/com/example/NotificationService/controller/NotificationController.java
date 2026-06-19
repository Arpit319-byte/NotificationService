package com.example.NotificationService.controller;


import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NotificationService.entity.Notification;
import com.example.NotificationService.service.INotificationService;

@RestController
@RequestMapping("api/v1/notificaton")
public class NotificationController {


    
    private INotificationService iNotificationService;

    public NotificationController(INotificationService iNotificationService){
        this.iNotificationService=iNotificationService;
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long notificationId){

        Notification notification= iNotificationService.getNotificationById(notificationId);
        return ResponseEntity.ok(notification);

    }


    @GetMapping("/user/{userId}/notification")
    public ResponseEntity<List<Notification>> getAllNotificatonByUserId(@PathVariable Long userId){
        
        List<Notification> notificationList=iNotificationService.getNotificationByUserId(userId);
        return ResponseEntity.ok(notificationList);

    }

    @PostMapping()
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification){
        
        Notification newNotification=iNotificationService.createNotificaton(notification);
        return ResponseEntity.ok(newNotification);

    }

    @PostMapping("/{notificationId}/retry")
    public ResponseEntity<Notification> retryNotificatonById(@PathVariable Long notificationId){

        Notification newNotification=iNotificationService.retryNotificationById(notificationId);
        return ResponseEntity.ok(newNotification);

    }



    
    
}
