package com.example.NotificationService.mapper;

import java.util.List;
import com.example.NotificationService.dto.user.UserRequest;
import com.example.NotificationService.dto.user.UserResponse;
import com.example.NotificationService.entity.User;

public final class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setNumber(request.getNumber());
        return user;
    }

    public static void updateEntity(User existing, UserRequest request) {
        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setNumber(request.getNumber());
    }

    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setNumber(user.getNumber());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        return response;
    }

    public static List<UserResponse> toResponseList(List<User> users) {
        return users.stream().map(UserMapper::toResponse).toList();
    }

}
