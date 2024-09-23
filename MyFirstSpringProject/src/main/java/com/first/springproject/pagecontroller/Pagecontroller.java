package com.first.springproject.pagecontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.springproject.form.UserForm;
import com.first.springproject.model.User;
import com.first.springproject.services.UserServices;
import com.first.springproject.utility.Helper;

import jakarta.servlet.http.HttpSession;

@Controller
public class Pagecontroller {
	

	@Autowired
	UserServices userServices;
	
	@GetMapping("/register")
	public String register(Model model)
	{
		UserForm userForm = new UserForm();
		//userForm.setName("Shivani");
		//userForm.setMobileNumber("8574944742");
		model.addAttribute("userForm",userForm);
		return "register";
	}
	
	
	@PostMapping("/do-register")
	public String processRegister(@ModelAttribute UserForm userForm,HttpSession httpSession)
	{
		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setMobileNumber(userForm.getMobileNumber());
		user.setPassword(userForm.getPassword());
		user.setDescription(userForm.getDescription());
		User savedUser =  userServices.saveUser(user);
		System.out.println("Registration Successfully!!");
		httpSession.setAttribute("message", "Registration Successfully");
		return "redirect:/register";
	}
	
	@RequestMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("title","Home - Smart contact manager");
		return "login";
	}
	
	@GetMapping("/login2")
	public String login2()
	{
		return "login2";
	}
	
	@GetMapping("/about")
	public String aboutPage()
	{
		return "about";
	}
	
	@GetMapping("/carrer")
	public String carrerPage()
	{
		return "carrer";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage()
	{
		return "dashboard";
	}
	
	@GetMapping("/")
	public String indexPage()
	{
		return "dashboard";
	}
	
	@GetMapping("/contact")
	public String contactPage()
	{
		return "contact";
	}
	
	
	 @GetMapping("/home") public String home() { return "home"; }
	 

}
