package com.spring.bean.Spring.Bean;

import ConfigurationBean.BeanCofiguration;
import Services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBeanApplication.class, args);

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanCofiguration.class);
		UserService user = (UserService)applicationContext.getBean(UserService.class);
		System.out.println("Printing user:"+user.getList());
	}

}
