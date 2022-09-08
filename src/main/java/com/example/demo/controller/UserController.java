package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userser;

    @Autowired
    public UserController(UserService userser) {
        this.userser = userser;
    }
    @GetMapping(path="all")
    public List<User> getUser(){return userser.getUsers();}
    @GetMapping(path="{id}")
    public User getUserById(@PathVariable("id") Long id){return userser.getUserById(id);}
    @PostMapping
    public void saveUser(@RequestBody User user){
        userser.saveUser(user);
    }
    @PutMapping(path="{id}")
    public void putUser(@PathVariable("id") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String username, @RequestParam(required = false) String email, @RequestParam(required = false) String about){
        userser.putUser(id, name, username, email, about);
    }

}
