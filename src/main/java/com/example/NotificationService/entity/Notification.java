package com.example.NotificationService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification extends BaseModel {
    
    @Column(nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Channel channel;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    private Status status;

}
