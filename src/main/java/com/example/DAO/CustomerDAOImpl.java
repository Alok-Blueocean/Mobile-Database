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
import com.example.Entity.OrderItem;
import com.example.Entity.Product;
import com.example.Entity.ProductDetails;
import com.example.Entity.Review;
import com.example.Entity.ShippingAgent;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	SessionFactory sessionFactory = new Configuration().configure()
			.addAnnotatedClass(Customer.class)
			.addAnnotatedClass(Address.class)
			.addAnnotatedClass(Cart.class)
			.addAnnotatedClass(Order.class)
			.addAnnotatedClass(OrderItem.class)
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(ProductDetails.class)
			.addAnnotatedClass(Review.class)
			.addAnnotatedClass(ShippingAgent.class)
			.buildSessionFactory();
	
	public CustomerDAOImpl() {}	
	@Transactional
	@Override
	public Customer getCustomerbyPhone(long phone) {
		
		Session session = sessionFactory.openSession();

		org.hibernate.Query query = 
				session.createQuery("from Customer where phone=?0");
		query.setLong(0, 1);
		Customer customer = (Customer) query.uniqueResult();
		return customer;
	}
	@Transactional
	@Override
	public void setCustomer(Customer customer) {
		System.out.println("setting customer...........");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("session is open...");
		session.save(customer);
		session.getTransaction().commit();
		session.close();
		System.out.println("session is closed...");
//		session.save(customer);
//		session.close();
		System.out.println("customer set...........");
	}
	
	@Transactional
	@Override
	public void setOrder(long id,Order order) {
		System.out.println("setting customer...........");
		
		Session session = sessionFactory.openSession();
		org.hibernate.Query query = 
				session.createQuery("from Customer where phone=?0");
		query.setLong(0, id);
		Customer customer = (Customer) query.uniqueResult();
//		Customer customer  = getCustomerbyPhone(id);
		customer.setOrder(order);
//		session.save(order);
		session.save(customer);
		System.out.println("order set...........");
		Customer customer1  = getCustomerbyPhone(id);
		System.out.println(customer1.getOrder());
		session.close();
	}
}

