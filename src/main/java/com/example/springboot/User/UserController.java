package com.example.springboot.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String getDefaultPage(){
        return "Welcome Fucker";
    }


    @PostMapping("/create-user")
    public List<User> createUser(@Validated @RequestBody User user){
       return userService.createUser(user);
    }

    @PostMapping("/delete-user")
    public List<User> deleteUser(@RequestBody User user){
       return userService.removeUser(user.getEmail());
    }

    @DeleteMapping("/delete-user/{userId}")
    public List<User> deleteUserById(
            @PathVariable(required = true) long userId,
            @RequestBody User user){
        return userService.removeUserById(userId);
    }

    @PutMapping("/update-user/{userId}")
    public void updateUser(
            @RequestBody User user,
            @PathVariable long userId){
        userService.updateUser(user, userId);
    }

    // Request param
    @GetMapping("/get-user-info")
    public String getUser(@RequestParam(name = "name") String name){
        return "the request param is "+ name;
    }


    @GetMapping("/get-request-Mapping")
    public String getRequestMapping(
            @RequestParam(name = "abc") String hehe
    ){
        return "the request param" + hehe;
    }
}
