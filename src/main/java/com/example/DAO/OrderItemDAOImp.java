package com.example.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.Address;
import com.example.Entity.Customer;
import com.example.Entity.Order;
import com.example.Entity.OrderItem;

public class OrderItemDAOImp {

	SessionFactory sessionFactory = new Configuration().configure()
			.addAnnotatedClass(Order.class)
			.addAnnotatedClass(OrderItem.class)
			.buildSessionFactory();
	
	public OrderItemDAOImp() {}
	
	@Transactional
	public void addOrderItems(OrderItem orderItem) {
		Session session = sessionFactory.openSession();
		session.save(orderItem);
		session.close();
	}
}
