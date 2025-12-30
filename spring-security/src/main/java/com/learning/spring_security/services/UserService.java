package com.learning.spring_security.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.spring_security.entity.Users;
import com.learning.spring_security.repository.UserRepo;

@Service
public class UserService {

	
	private final UserRepo repo;
	private final BCryptPasswordEncoder encoder;
	
	public UserService(UserRepo repo, BCryptPasswordEncoder encoder) {
		super();
		this.repo = repo;
		this.encoder = encoder;
	}

	public Users register(Users user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
	
	
}
