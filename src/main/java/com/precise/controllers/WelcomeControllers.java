package com.precise.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeControllers {
	@GetMapping
	public String welcome() {
		return "Welcome to Spring Buddy";
	}
	
	@PostMapping
	public String postWelcome() {
		return "Welcome to spring post buddy";
	}
}
