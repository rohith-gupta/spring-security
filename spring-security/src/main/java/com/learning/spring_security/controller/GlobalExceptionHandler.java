package com.learning.spring_security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learning.spring_security.exceptions.ProductNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> handler(ProductNotFoundException exception)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		
	}

}
