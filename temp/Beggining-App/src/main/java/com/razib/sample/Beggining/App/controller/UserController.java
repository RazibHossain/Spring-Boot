package com.razib.sample.Beggining.App.controller;

import com.razib.sample.Beggining.App.Dto.UserDto;
import com.razib.sample.Beggining.App.request.model.UserDetailsRequestModel;
import com.razib.sample.Beggining.App.response.model.UserRest;
import com.razib.sample.Beggining.App.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "user name returns";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();

         UserDto userDto = new UserDto();
         BeanUtils.copyProperties(userDetails, userDto);
         UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties (createdUser,returnValue);

        return returnValue;
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
