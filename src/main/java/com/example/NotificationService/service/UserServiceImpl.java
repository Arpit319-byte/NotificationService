package com.example.NotificationService.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.NotificationService.entity.User;
import com.example.NotificationService.exception.DuplicateResourceException;
import com.example.NotificationService.exception.ResourceNotFoundException;
import com.example.NotificationService.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

   
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public User getUserById(Long id) {
        User user=userRepository.findById(id)
                  .orElseThrow(()->new ResourceNotFoundException("User with the given id: "+id+" is not present in the DB" ));

        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList= userRepository.findAll();
        return userList;
    }

    @Override
    public User createUser(User user) {

        if(userRepository.existsByEmail(user.getEmail()))
            throw new DuplicateResourceException("User cannot be created as the email already exists: "+user.getEmail());

        if(userRepository.existsByNumber(user.getNumber()))
            throw new DuplicateResourceException("User cannot be created as the number already exists: "+user.getNumber());

        User saved = userRepository.save(user);
        return saved;
    }

    @Override
    public User updateUserById(Long userId, User user) {
        
        if(userRepository.findById(userId) == null)
            throw new ResourceNotFoundException("No user with the userId: "+userId+" is present due which it can not bge udpdated");

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @Override
    public Boolean deleteUserById(Long userId) {
        
        if(userRepository.findById(userId) == null)
            throw new ResourceNotFoundException("No user with the userId: "+userId+" is present due which it can not be deleted");

        userRepository.deleteById(userId);
        return true;
    }
    
}
