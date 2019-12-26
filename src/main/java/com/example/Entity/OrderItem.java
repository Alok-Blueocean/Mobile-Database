package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
