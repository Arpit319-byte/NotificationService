package com.example.NotificationService.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.NotificationService.dto.notification.CreateNotificationRequest;
import com.example.NotificationService.dto.notification.NotificationResponse;
import com.example.NotificationService.service.INotificationService;

@RestController
@RequestMapping("api/v1/notificaton")
public class NotificationController {

    private final INotificationService notificationService;

    public NotificationController(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationResponse> getNotificationById(
            @PathVariable Long notificationId) {
        return ResponseEntity.ok(notificationService.getNotificationById(notificationId));
    }

    @GetMapping("/user/{userId}/notification")
    public ResponseEntity<List<NotificationResponse>> getAllNotificatonByUserId(
            @PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getNotificationByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<NotificationResponse> createNotification(
            @Valid @RequestBody CreateNotificationRequest request) {
        return ResponseEntity.ok(notificationService.createNotificaton(request));
    }

    @PostMapping("/{notificationId}/retry")
    public ResponseEntity<NotificationResponse> retryNotificatonById(
            @PathVariable Long notificationId) {
        return ResponseEntity.ok(notificationService.retryNotificationById(notificationId));
    }

}
