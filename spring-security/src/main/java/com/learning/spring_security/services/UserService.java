package com.learning.spring_security.services;

import java.util.Objects;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.spring_security.entity.Users;
import com.learning.spring_security.repository.UserRepo;

@Service
public class UserService {
	
	private final UserRepo repo;
	private final BCryptPasswordEncoder encoder;
	
	private final AuthenticationManager authenticationManager;
	
	public UserService(UserRepo repo, BCryptPasswordEncoder encoder, AuthenticationManager authenticationManager) {
		super();
		this.repo = repo;
		this.encoder = encoder;
		this.authenticationManager = authenticationManager;
	}

	public Users register(Users user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

	public String verifyLogin(Users user) {
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//		Users u = repo.findByUsername(user.getUsername());
		if(authentication.isAuthenticated())
			return "Login success";
		return "Login failed";
	}
	
	
}
