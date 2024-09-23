package com.first.springproject.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@PostMapping("/userdashboard")
	public String userDashboardPage()
	{
		return "user/dashboard";
	}
	
	/*
	 * @GetMapping("/userprofile") public String userProfilePage() { return
	 * "user/profile"; }
	 */
	
	@GetMapping("/userhome")
	public String userProfilePage()
	{
		return "user/profile";
	}

}
