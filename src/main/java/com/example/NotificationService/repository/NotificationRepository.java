package com.example.NotificationService.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.NotificationService.entity.Notification;
import com.example.NotificationService.entity.Status;

public interface NotificationRepository extends JpaRepository<Notification,Long>{

    List<Notification> findByUserId(Long userId);
    List<Notification> findByStatus(Status status);
    
}
