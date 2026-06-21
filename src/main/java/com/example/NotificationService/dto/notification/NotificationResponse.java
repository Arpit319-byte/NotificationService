package com.example.NotificationService.dto.notification;

import java.time.Instant;
import com.example.NotificationService.entity.Channel;
import com.example.NotificationService.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {

    private Long id;
    private Long userId;
    private Channel channel;
    private String subject;
    private String message;
    private Status status;
    private Instant createdAt;
    private Instant updatedAt;

}
