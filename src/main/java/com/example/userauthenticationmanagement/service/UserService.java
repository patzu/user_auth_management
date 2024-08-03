package com.example.userauthenticationmanagement.service;

import com.example.userauthenticationmanagement.entity.MyUser;
import com.example.userauthenticationmanagement.exception.CustomServiceException;
import com.example.userauthenticationmanagement.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public MyUser saveUser(MyUser myUser) {
        myUser.setPassword(bCryptPasswordEncoder.encode(myUser.getPassword()));
        try {
            return userRepository.save(myUser);
        } catch (Exception e) {
            throw new CustomServiceException(e.getMessage(), e);
        }
    }
}