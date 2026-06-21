package com.example.NotificationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.NotificationService.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByEmail(String email);
    Boolean existsByNumber(String number);

} 