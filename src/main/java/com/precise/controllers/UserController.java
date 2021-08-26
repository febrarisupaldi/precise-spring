package com.precise.controllers;

import java.io.Console;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.precise.dto.ResponseData;
import com.precise.dto.UserData;
import com.precise.models.entities.User;
import com.precise.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseData<User>> register(@RequestBody UserData userData){
		ResponseData<User> response = new ResponseData<>();
		User user = modelMapper.map(userData, User.class);
		response.setPayload(userService.registerUser(user));
		response.setStatus(true);
		response.getMessages().add("User Saved");
		//System.out.println("akwoakwaokwowakwaokwaowakwao" +userData.getUserRole());
		return ResponseEntity.ok(response);
	}
}
