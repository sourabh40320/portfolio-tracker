package com.local.portfolio.controller;

import com.local.portfolio.data.entity.User;
import com.local.portfolio.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Sourabh
 **/
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("user/{id}")
    public User get(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseGet(User::new);
    }

    @GetMapping("user")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
