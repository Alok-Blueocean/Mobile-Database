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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/*
 * @Transient - that column will not be stored
 * 
 */
@Component
@Entity
@Table(name = "customer")
public class Customer {


	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long phone;

	/*
	 * for onetomany default fetchtype is Lazy
	 * 
	 */
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<Address> addresses;
	
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "order_customer_id")
	private Order cusOrder;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public Customer() {}
	public Customer(String name, long phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public Order getOrder() {
		return cusOrder;
	}
	public void setOrder(Order order) {
		this.cusOrder = order;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
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
	public void addAddress(Address address) {
		if(addresses==null) {
			addresses = new ArrayList<Address>();
		}
		addresses.add(address);
		address.setCustomer(this);
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddress(List<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone +   "]";
	}

}
