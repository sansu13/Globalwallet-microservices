package com.globalwallet.userservice.controller;

import com.globalwallet.userservice.entity.User;
import com.globalwallet.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/test")
    public String test() {
        return "User Service Working!";
    }
}