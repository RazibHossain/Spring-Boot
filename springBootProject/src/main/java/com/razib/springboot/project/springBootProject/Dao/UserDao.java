package com.razib.springboot.project.springBootProject.Dao;

import com.razib.springboot.project.springBootProject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<Users,Integer> {

    @Query(value = "select * from Users ",nativeQuery = true)
    List<Users> getAllUser();

    Users getById(Integer id);

    Users getByUserName(String name);
    @Query(value = "select * from Users\n" +
            "where username = ?1 or ?1 is null or ?1 = \"\"\n" +
            "  having user_id =?2 or ?2 is null or ?2 = \"\"", nativeQuery = true)
    List<Users> getUserReport(String name, String uid  );
//    List<Users> findAll();
}
