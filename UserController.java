package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor of " + getClass());
System.out.println("Hello World");

	}

	@GetMapping("/register")
	public String showNewVendorForm(User u) {
		return "/user/register";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}
	@GetMapping("/chatbox")
	public String showChatBox(User u) {
		return "/user/chatbox";
	}

	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam("pass") String pwd, Model map)
	
	{
		System.out.println("in process login form " + email + " " + pwd + " " + map);
		try {
			
			User user = userService.authenticateUser(email, pwd);
			map.addAttribute("mesg",
					"Login Successful, Hello , " + user.getName() + " , logged in under " + user.getName() + " role");
						if (user!= null)
				return "/user/allUser";
			
			return "/user/login";
		} catch (RuntimeException e) {
			System.out.println("err in " + getClass() + " exc " + e);
			map.addAttribute("mesg", "Invalid Login , Please retry !!!!!!!!!!!!!");
			return "/user/login";
		}
		
	}

}
