package com.razib.springboot.project.springBootProject.Service;

import com.razib.springboot.project.springBootProject.Dao.UserDao;
import com.razib.springboot.project.springBootProject.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);

    }

    public List<Users> findUsers(){
//     return  userDao.getAllUser();

        return userDao.findAll();
    }

    public void deleteById(Integer userId){
        userDao.deleteById(userId);
    }

    public Users findUser(Integer id) {
        return userDao.getById(id);
    }
    public void updateUser(Users user){
        Users users = userDao.getById(user.getId());

        users.setUserName(user.getUserName());
        users.setPassword(passwordEncoder.encode(user.getPassword()));
        users.setenabled(user.isenabled());
        users.setRole(user.getRole());
        userDao.save(users);
    }
}
