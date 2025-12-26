package com.learning.spring_security.entity;




public class Products {
	
	private int id;
	private String productname;
	private int quantity;
	private double price;
	
	
	public Products(int id, String productname, int quantity, double price) {
		super();
		this.id = id;
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", productname=" + productname + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
	

}
