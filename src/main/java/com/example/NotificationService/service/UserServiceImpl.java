package com.example.NotificationService.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.NotificationService.dto.user.UserRequest;
import com.example.NotificationService.dto.user.UserResponse;
import com.example.NotificationService.entity.User;
import com.example.NotificationService.exception.DuplicateResourceException;
import com.example.NotificationService.exception.ResourceNotFoundException;
import com.example.NotificationService.mapper.UserMapper;
import com.example.NotificationService.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getUserById(Long id) {
        return UserMapper.toResponse(findUserOrThrow(id));
    }

    @Override
    public List<UserResponse> getAllUser() {
        return UserMapper.toResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        validateUniqueEmailAndNumber(request.getEmail(), request.getNumber(), null);

        User user = UserMapper.toEntity(request);
        User saved = userRepository.save(user);
        return UserMapper.toResponse(saved);
    }

    @Override
    public UserResponse updateUserById(Long userId, UserRequest request) {
        User existing = findUserOrThrow(userId);
        validateUniqueEmailAndNumber(request.getEmail(), request.getNumber(), userId);

        UserMapper.updateEntity(existing, request);
        User saved = userRepository.save(existing);
        return UserMapper.toResponse(saved);
    }

    @Override
    public void deleteUserById(Long userId) {
        findUserOrThrow(userId);
        userRepository.deleteById(userId);
    }

    private User findUserOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with id: " + id));
    }

    private void validateUniqueEmailAndNumber(String email, String number, Long excludeUserId) {
        userRepository.findByEmail(email).ifPresent(user -> {
            if (excludeUserId == null || !user.getId().equals(excludeUserId)) {
                throw new DuplicateResourceException("Email already exists: " + email);
            }
        });
        userRepository.findByNumber(number).ifPresent(user -> {
            if (excludeUserId == null || !user.getId().equals(excludeUserId)) {
                throw new DuplicateResourceException("Number already exists: " + number);
            }
        });
    }

}
