package com.example.NotificationService.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.NotificationService.dto.notification.CreateNotificationRequest;
import com.example.NotificationService.dto.notification.NotificationResponse;
import com.example.NotificationService.entity.Notification;
import com.example.NotificationService.entity.Status;
import com.example.NotificationService.exception.InvalidNotificationStateException;
import com.example.NotificationService.exception.ResourceNotFoundException;
import com.example.NotificationService.mapper.NotificationMapper;
import com.example.NotificationService.repository.NotificationRepository;
import com.example.NotificationService.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class NotificationServiceImpl implements INotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository,UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository=userRepository;
    }

    @Override
    public NotificationResponse createNotificaton(CreateNotificationRequest request) {

        Notification notification = NotificationMapper.toEntity(request);

        if(!userRepository.existsById(notification.getUserId())){
            throw new ResourceNotFoundException("User not found with id: " + request.getUserId());
        }
    
        if (notification.getStatus() == null) {
            notification.setStatus(Status.PENDING);
        }
        Notification saved = notificationRepository.save(notification);
        return NotificationMapper.toResponse(saved);
    }

    @Override
    public NotificationResponse getNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Notification not found with id: " + id));
        return NotificationMapper.toResponse(notification);
    }

    @Override
    public List<NotificationResponse> getNotificationByUserId(Long userId) {
        List<Notification> notificationList = notificationRepository.findByUserId(userId);
        return NotificationMapper.toResponseList(notificationList);
    }

    @Override
    @Transactional
    public NotificationResponse retryNotificationById(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Notification not found with id: " + notificationId));

        if (notification.getStatus() != Status.FAILED) {
            throw new InvalidNotificationStateException(
                    "Only FAILED notifications can be retried. Current status: "
                            + notification.getStatus());
        }

        notification.setStatus(Status.PENDING);
        Notification saved = notificationRepository.save(notification);
        return NotificationMapper.toResponse(saved);
    }

}
