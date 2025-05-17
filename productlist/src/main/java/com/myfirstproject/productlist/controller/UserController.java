package com.myfirstproject.productlist.controller;

import com.myfirstproject.productlist.entity.User;
import com.myfirstproject.productlist.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register (@RequestBody User user){

       return userService.createUser(user);
    }
}
