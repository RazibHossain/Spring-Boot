package com.razib.sample.Beggining.App.service;

import com.razib.sample.Beggining.App.Dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService  {
    UserDto createUser(UserDto user);
}
