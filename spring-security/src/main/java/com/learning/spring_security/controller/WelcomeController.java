package com.learning.spring_security.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class WelcomeController {
	
	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to Spring Security learnings";
	}
	
	
	@GetMapping("/token")
	public CsrfToken getToken(HttpServletRequest request)
	{
		return (CsrfToken) request.getAttribute("_csrf");
	}

}
