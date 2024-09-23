package com.first.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.first.springproject.model.User;
import com.first.springproject.repository.UserRepository;
import com.first.springproject.repository.UserReso;

@SpringBootApplication
public class MyFirstSpringProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(MyFirstSpringProjectApplication.class, args);
		
//		UserRepository userreso= context.getBean(UserRepository.class);
//		User user=new User();
//		user.setName("Shivani");
//		user.setEmail("shivani@gmail.com");
//		user.setMobileNumber("9123456789");
//		user.setDescription("Testing");
//		user.setPassword("Shiv");
//		User user1=userreso.save(user);
//		System.out.println(user1);
	}

}
