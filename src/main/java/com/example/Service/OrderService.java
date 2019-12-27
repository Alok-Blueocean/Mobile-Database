package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.OrderDAO;
import com.example.DAO.OrderDAOImpl;
import com.example.DAO.OrderItemDAO;
import com.example.DAO.OrderItemDAOImp;
import com.example.Entity.Order;
import com.example.Entity.OrderItem;
import com.example.Entity.Product;

@Service
public class OrderService {

	public OrderService() {}

	@Autowired
	OrderItemDAO orderItemDAO;
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	OrderItem orderItem;
	@Autowired
	Order order;
	
	public void addProductOrder(Product product,int quantity) {
		
		orderItem.setQuantity(quantity);
		orderItem.setProduct(product);
		order.addOrderItem(orderItem);
		orderDAO.addOrder(order);
	}
	
}

