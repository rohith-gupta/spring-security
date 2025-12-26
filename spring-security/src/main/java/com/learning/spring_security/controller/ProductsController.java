package com.learning.spring_security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring_security.entity.Products;

@RestController
public class ProductsController {
	
	List<Products> product = new ArrayList<>( List.of( new Products(1,"samsung flip7",2,1299.00),
														new Products(2,"google buds2 pro",1,599.00)));
	
	@GetMapping("/products")
	public List<Products> getAll()
	{
		return product;
	}
	
	@GetMapping("/products/{id}")
	public Products getProduct(@PathVariable int id)
	{
		for(int i=0;i<product.size();i++)
		{
			Products prod = product.get(i);
			if(prod.getId() == id)
			{
				return prod;
			}
		}
		return null;
		
	}
	
	
	@PostMapping("/products")
	public Products setProduct(@RequestBody Products prod)
	{
		product.add(prod);
		
		return prod;
	}

}
