package com.first.springproject.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.first.springproject.model.User;
import com.first.springproject.repository.UserRepository;
import com.first.springproject.services.UserServices;
import com.first.springproject.utility.ApplicationConstant;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoleList(List.of(ApplicationConstant.ROLE_USER));
		return userRepository.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email).orElse(null);
	}

}
