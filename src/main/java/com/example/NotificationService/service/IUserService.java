package com.example.NotificationService.service;

import java.util.List;
import com.example.NotificationService.dto.user.UserRequest;
import com.example.NotificationService.dto.user.UserResponse;

public interface IUserService {

    UserResponse getUserById(Long id);
    List<UserResponse> getAllUser();
    UserResponse createUser(UserRequest request);
    UserResponse updateUserById(Long userId, UserRequest request);
    void deleteUserById(Long userId);

}
