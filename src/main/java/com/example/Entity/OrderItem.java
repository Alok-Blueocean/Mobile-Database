package com.example.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItem {
	
	@Autowired
	private Product product;
	
	private int quantity;
	
	@Override
	public String toString() {
		return "OrderItem [product=" + product + ", quantity=" + quantity + "]";
	}

	public OrderItem(Product product,int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public double getTotalAmount() {
		return product.getPrice()*quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderItem() {

	}
	public void putOrder(Product product,int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
}
