package com.example.NotificationService.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.NotificationService.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Long>{

    Optional<List<Notification>> findByUserId(Long userId);
    
}
