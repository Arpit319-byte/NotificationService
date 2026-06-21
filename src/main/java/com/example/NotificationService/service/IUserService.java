package com.example.NotificationService.service;

import java.util.List;
import com.example.NotificationService.entity.User;

public interface IUserService {

    public User getUserById(Long id);
    public List<User> getAllUser();
    public User createUser(User user);
    public User updateUserById(Long userId,User user);
    public Boolean deleteUserById(Long userId);

    
}
