package com.example.NotificationService.sender;

import com.example.NotificationService.entity.Channel;
import com.example.NotificationService.entity.Notification;
import com.example.NotificationService.entity.User;
import com.example.NotificationService.exception.ResourceNotFoundException;
import com.example.NotificationService.repository.UserRepository;

public class PushChannelSender implements ChannelSender{

    private final UserRepository userRepository;

    public PushChannelSender(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public Channel getChannel() {
       return Channel.PUSH;
    }

    @Override
    public void sendNotification(Notification notification) throws Exception {
        
                
        User user=userRepository.findById(notification.getUserId())
                  .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + notification.getUserId()));

        System.out.printf("PUSH → %s | subject: %s | body: %s%n",
        user.getEmail(), notification.getSubject(), notification.getMessage());
                  
    }
    
    
}
