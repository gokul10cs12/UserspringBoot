package com.example.springboot.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public List<User> removeUser(String email) {
        if (userRepository.findUserByEmail(email).isEmpty()) {
            throw new IllegalStateException("email already exist");
        }
        userRepository.deleteUserByEmail(email);
        return userRepository.findAll();
    }

    public List<User> removeUserById(long userId) {
        if (!userRepository.existsById(userId)){
            throw new IllegalStateException("not found");
        }
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }
    @Transactional
    public void updateUser(User user, long userId) {
        User updateUser = userRepository.getById(userId);
        if (!user.getName().equals(updateUser.getName())){
            updateUser.setName(user.getName());
            updateUser.setEmail(user.getEmail());
        }
        else {
            throw new IllegalStateException("Error user info update failed.");
        }

    }
}

