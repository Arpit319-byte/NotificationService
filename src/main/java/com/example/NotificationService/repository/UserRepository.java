package com.example.NotificationService.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.NotificationService.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);
    boolean existsByNumber(String number);
    Optional<User> findByEmail(String email);
    Optional<User> findByNumber(String number);

} 