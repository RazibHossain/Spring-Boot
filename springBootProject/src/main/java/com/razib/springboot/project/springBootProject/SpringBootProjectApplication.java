package com.razib.springboot.project.springBootProject;

import com.razib.springboot.project.springBootProject.Dao.UserDao;
import com.razib.springboot.project.springBootProject.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//Repository class k enale korte hoi main function theke
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
//@EnableJpaRepositories(basePackageClasses = UserDao.class)
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

}
