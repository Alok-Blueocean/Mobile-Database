package com.example.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.Order;
import com.example.Entity.OrderItem;

public class OrderDAOImpl {
	
	SessionFactory sessionFactory = new Configuration().configure()
			.addAnnotatedClass(Order.class)
			.addAnnotatedClass(OrderItem.class)
			.buildSessionFactory();

	public OrderDAOImpl() {}
	
	@Transactional
	public void addOrder(Order order) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(order);
		session.close();
	}

}
