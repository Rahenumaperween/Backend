package com.portfolio.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;
    
    //GET ALL USER
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }
    //GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }
    
    //UPDATE USER
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        return ResponseEntity.ok(service.updateUser(id, user));
    }
    
    //DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        service.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
