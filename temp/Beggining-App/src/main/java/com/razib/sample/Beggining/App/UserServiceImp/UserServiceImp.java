package com.razib.sample.Beggining.App.UserServiceImp;

import com.razib.sample.Beggining.App.Dto.UserDto;
import com.razib.sample.Beggining.App.model.UserEntity;
import com.razib.sample.Beggining.App.repository.UserRepository;
import com.razib.sample.Beggining.App.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");
        UserEntity storedUserDetails=userRepository.save(userEntity);

        UserDto returnvalue=new UserDto();
        BeanUtils.copyProperties(storedUserDetails,returnvalue);
        return returnvalue;
    }
}
