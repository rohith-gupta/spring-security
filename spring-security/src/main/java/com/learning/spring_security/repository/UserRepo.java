package com.learning.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.spring_security.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	
	
	public Users findByUsername(String username);

}
