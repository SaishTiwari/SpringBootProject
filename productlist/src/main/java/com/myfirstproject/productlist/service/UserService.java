package com.myfirstproject.productlist.service;

import com.myfirstproject.productlist.entity.User;
import com.myfirstproject.productlist.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser (User user){
       return userRepository.save(user);
    }

}
