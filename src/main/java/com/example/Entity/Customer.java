package com.example.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer {

	private String name;
	private long phone;
	
	@Autowired
	private Address address;
	
	@Autowired
	private Order order;
	@Autowired
	private OrderItem orderItem;

	@Autowired
	Invoice invoice;
	
	public Customer() {}
	public Customer(String name, long phone, Address address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Invoice buyNow(Product product,int quantity) {
		orderItem.putOrder(product, quantity);
		order.addOrder(orderItem);
		invoice.createInvoice();
		order.clear();
		return invoice;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone + ", address=" + address + ", order=" + order
				+ "]";
	}
	
}
