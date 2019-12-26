package com.example.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;

import com.example.Entity.Address;
import com.example.Entity.Cart;
import com.example.Entity.Customer;
import com.example.Entity.Order;
import com.example.Entity.Review;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	//	@Autowired
	//	private SessionFactory sessionFactory;

	//	public SessionFactory getSessionFactory() {
	//		return sessionFactory;
	//	}
	//	public void setSessionFactory(SessionFactory sessionFactory) {
	//		this.sessionFactory = sessionFactory;
	//	}
	public CustomerDAOImpl() {}	
	@Transactional
	@Override
	public Customer getCustomerbyPhone(long phone) {
		SessionFactory sessionFactory = new Configuration().configure()
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Cart.class)
				.addAnnotatedClass(Order.class)
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		org.hibernate.query.Query query = 
				session.createQuery("from Customer where phone=?0");
		query.setLong(0, 1);
		Customer customer = (Customer) query.uniqueResult();
		return customer;
	}
}
