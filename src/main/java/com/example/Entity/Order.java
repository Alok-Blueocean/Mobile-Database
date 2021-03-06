package com.example.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Productorder")
public class Order {
	
	public Order() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(name = "order_item_id")
	private List<OrderItem> ordersItems;
	
	@OneToOne(mappedBy = "cusOrder",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Customer customer;
	

	public void addOrderItem(OrderItem orderItem) {
		System.out.println(orderItem);
		if (ordersItems==null) {
			ordersItems = new ArrayList<OrderItem>();
		}
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
		return "Order [id=" + id + ", ordersItems=" + ordersItems + ", customer=" + customer + "]";
	}
	public List<OrderItem> getOrdersItems() {
		return ordersItems;
	}
	public void setOrdersItems(List<OrderItem> ordersItems) {
		this.ordersItems = ordersItems;
	}
	public long getOrderId() {
		return id;
	}
	public void setOrderId(long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
