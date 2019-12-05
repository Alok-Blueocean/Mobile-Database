package com.example.Entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Order {
	private List<OrderItem> ordersItems = new ArrayList<OrderItem>();
	private long orderId;
	
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
	
}
