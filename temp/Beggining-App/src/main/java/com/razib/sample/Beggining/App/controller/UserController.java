package com.razib.sample.Beggining.App.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUser(){
        return "user name returns";
    }

    @PostMapping
    public String createUser(){
        return "new user create";
    }
    @PutMapping
    public String updateUser(){
        return "update user";
    }
    @DeleteMapping
    public String deleteUser(){
        return "delete user";
    }


}
