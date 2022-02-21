package com.example.springboot.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> createUser(User user){
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()){
            throw new IllegalStateException("email already exist");
        }else {
            userRepository.save(user);
        }

        return userRepository.findAll();
    }

    public List<User> removeUser(String email) {
        if (userRepository.findUserByEmail(email).isEmpty()) {
            throw new IllegalStateException("email already exist");
        }
        userRepository.deleteUserByEmail(email);
        return userRepository.findAll();
    }
    }

