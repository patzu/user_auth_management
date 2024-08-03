package com.example.userauthenticationmanagement.controller;

import com.example.userauthenticationmanagement.entity.MyUser;
import com.example.userauthenticationmanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class RegistrationController {
    UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/")
    public ResponseEntity<MyUser> registration(@RequestBody MyUser myUser) {
        MyUser savedUser = userService.saveUser(myUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
