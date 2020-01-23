package com.example.DAO;

import com.example.Entity.Customer;
import com.example.Entity.Order;


public interface CustomerDAO {
	
	public Customer getCustomerbyPhone(long phone); 
	public void setCustomer(Customer customer);
	void setOrder(long id, Order order);
}
