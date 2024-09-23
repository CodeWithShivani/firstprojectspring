package com.first.springproject.pagecontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.first.springproject.model.User;
import com.first.springproject.services.UserServices;
import com.first.springproject.utility.Helper;


@ControllerAdvice
public class RootController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserServices userServices;
	
	
	
	@ModelAttribute
	public void addLoggedInUserInformation(Model model, Authentication authentication) {
		if (authentication == null) {
			return;
		}
		String userName = Helper.getEmailOfLoggedInUser(authentication);
		System.out.println("Adding logged In User Information to the model");
		logger.info("User logged in : {}", userName);
		User user = userServices.getUserByEmail(userName);
		System.out.println("User :" + user);
		System.out.println("User Name :" + user.getName());
		System.out.println("User Email :" + user.getEmail());
		model.addAttribute("loggedInUser", user);

	}
	

}
