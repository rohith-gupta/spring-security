package com.learning.spring_security.controller;
import java.util.Objects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.learning.spring_security.entity.Users;
import com.learning.spring_security.repository.UserRepo;
import com.learning.spring_security.services.UserService;

@RestController
public class UserController {

	
	private UserRepo userRepo;
	private UserService userService;


	public UserController(UserRepo userRepo, UserService userService) {
		super();
		this.userRepo = userRepo;
		this.userService = userService;
	}


	@PostMapping("/register")
	public Users registerUser(@RequestBody Users user)
	{
		return userService.register(user);
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody Users user)
	{
		Users u = userRepo.findByUsername(user.getUsername());
		if(!Objects.isNull(u))
			return "success";
		return "login failed";
	}
	 

}
