package com.razib.springboot.project.springBootProject.Repository;
import com.razib.springboot.project.springBootProject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
//crud operation/dao er moto behave kore repositoy class
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUserName(String userName);


}