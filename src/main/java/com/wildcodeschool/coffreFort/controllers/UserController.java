package com.wildcodeschool.coffreFort.controllers;

import com.wildcodeschool.coffreFort.entity.User;
import com.wildcodeschool.coffreFort.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public List<User> index() {
        List<User> users  = repository.findAll();
        return users;
    }

    @GetMapping("/users/{userId}")
    public User show(@PathVariable Long userId) {
        User user = new User();
        if(userId != null) {
            Optional<User> optionalUser = repository.findById(userId);
            if(optionalUser.isPresent()) {
                user = optionalUser.get();
            }
        }
        return user;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        repository.save(user);
    }
} // login -> /safes
