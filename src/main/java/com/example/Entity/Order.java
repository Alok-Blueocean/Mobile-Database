package com.example.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Order {
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderItem> ordersItems = new ArrayList<OrderItem>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long orderId;
	
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	private Customer customer;
	
	public Order() {
	}
	public Order(Customer customer) {
		orderId = customer.getPhone();
	}
	public void addOrder(OrderItem orderItem) {
		ordersItems.add(orderItem);
	}
	public void removeOrder(OrderItem orderItem) {
		ordersItems.remove(orderItem);
	}
	public double getTotalAmount() {
		double amount = ordersItems.stream()
				.reduce(0.0,(x,y)->x + y.getTotalAmount(),
						Double::sum);
		return amount;
	}
	public void clear() {
		ordersItems.clear();
	}
	@Override
	public String toString() {
		return "Order [ordersItems=" + ordersItems + ", orderId=" + orderId + "]";
	}
	public List<OrderItem> getOrdersItems() {
		return ordersItems;
	}
	public void setOrdersItems(List<OrderItem> ordersItems) {
		this.ordersItems = ordersItems;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
