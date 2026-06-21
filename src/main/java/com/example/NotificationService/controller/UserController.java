package com.example.NotificationService.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NotificationService.entity.User;
import com.example.NotificationService.service.IUserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService=userService;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){

        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        
        User saved = userService.createUser(user);
        return ResponseEntity.ok(saved);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable Long userId,@RequestBody User user){

        User updatedUser = userService.updateUserById(userId,user);
        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable Long userId){

        Boolean isDeleted = userService.deleteUserById(userId);
        return ResponseEntity.ok(isDeleted);
    }

    
}
