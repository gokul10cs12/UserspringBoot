package com.example.springboot.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    // Request param
    @GetMapping("/get-user-info")
    public String getUser(@RequestParam(name = "name") String name){
        return "the request param is "+ name;
    }

    //Path param
    @GetMapping("/get-user-details/{name}")
    public String getUserDetails(@PathVariable(required = false) String name ){
        return "the path param working=" + name;
    }

    @GetMapping("/get-my-details/{name}")
    public String getMyName(@PathVariable(required = false) String name){
        return "my name is" + name;
    }


    @GetMapping("/get-request-Mapping")
    public String getRequestMapping(
            @RequestParam(name = "abc") String hehe
    ){
        return "the request param" + hehe;
    }
}
