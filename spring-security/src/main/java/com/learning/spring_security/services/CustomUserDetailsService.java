package com.learning.spring_security.services;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.learning.spring_security.entity.Users;
import com.learning.spring_security.repository.UserRepo;


@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	
	private final UserRepo repo;
	
	


	public CustomUserDetailsService(UserRepo repo) {
		super();
		this.repo = repo;
	}




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = repo.findByUsername(username);
		if(Objects.isNull(user))
		{
			System.out.println("User not Found");
			throw new UsernameNotFoundException("User not Found");
		}
		return new CustomUserDetails(user);
	}

}
