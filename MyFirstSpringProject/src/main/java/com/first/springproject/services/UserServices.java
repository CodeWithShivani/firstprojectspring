package com.first.springproject.services;

import com.first.springproject.model.User;

public interface UserServices {

	User saveUser(User user);
	User getUserByEmail(String email);

}
