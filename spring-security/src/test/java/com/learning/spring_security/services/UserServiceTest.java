package com.learning.spring_security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learning.spring_security.entity.Users;
import com.learning.spring_security.repository.UserRepo;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	UserRepo repo;
	
	@InjectMocks
	UserService userService;
	
	@Mock
	BCryptPasswordEncoder encoder;

	@Test
	void registerTestUser() {
		
		Users user = new Users();
		user.setId(1);
		user.setUsername("rohith");
		user.setPassword(encoder.encode("rohith"));
		Mockito.when(repo.save(user)).thenReturn(user);
		Users testUser = userService.register(user);
		
		Assertions.assertEquals(user.getPassword(), testUser.getPassword());
		
	}

}
