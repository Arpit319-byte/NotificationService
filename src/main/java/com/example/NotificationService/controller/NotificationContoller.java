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

@RestController
@RequestMapping("api/v1/notificaton")
public class NotificationContoller {





    @GetMapping("/{notificationId}")
    public ResponseEntity<?> getNotificationById(@PathVariable Long notificationId){

    }


    @GetMapping("/user/{userId}/notification")
    public ResponseEntity<List<Notification>> getAllNotificatonByUserId(@PathVariable Long useriD){
        
    }

    @PostMapping()
    public ResponseEntity<?> createNotification(@RequestBody Notification notification){
        
        return ResponseEntity.ok(null);
    }

    @PostMapping("/{notificationId}/retry")
    public ResponseEntity<?> retryNotificatonById(@RequestBody Notification notification){

    }



    
    
}
