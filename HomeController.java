package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("in ctor of "+getClass());
System.out.println("Welcome!!!");
	}
	
	@GetMapping("/")
	public String showHomePage()
	{
		System.out.println("in show home page");
		return "/index";
		Sysem.out.println("Hello!!!");
	}

}
