package com.example.Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Admin {
	
	private String nameString;
	private String idString;
	private List<Product> products = new ArrayList<Product>();
	public Admin() {
	}
	public Admin(String nameString, String idString) {
		super();
		this.nameString = nameString;
		this.idString = idString;
	}
	public void addProduct(Product ppProduct) {
		this.products.add(ppProduct);
	}
	public List<Product> getProducts() {
		return this.products;
	}
	public static void main(String[] args) {

	}
	@Override
	public String toString() {
		return "Admin [nameString=" + nameString + ", idString=" + idString + ", products=" + products + "]";
	}

}
