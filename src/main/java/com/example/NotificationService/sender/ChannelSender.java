package com.example.NotificationService.sender;



import com.example.NotificationService.entity.Channel;
import com.example.NotificationService.entity.Notification;

public interface ChannelSender {

    Channel getChannel();
    void sendNotification(Notification notification) throws Exception;
    
    
}
