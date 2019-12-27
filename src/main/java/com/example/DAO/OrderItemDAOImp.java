package com.example.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
public class OrderItemDAOImp implements OrderItemDAO {

	SessionFactory sessionFactory = new Configuration().configure()
			.addAnnotatedClass(Order.class)
			.addAnnotatedClass(OrderItem.class)
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(ProductDetails.class)
			.addAnnotatedClass(Review.class)
			.addAnnotatedClass(ShippingAgent.class)
			.addAnnotatedClass(Customer.class)
			.addAnnotatedClass(Address.class)
			.addAnnotatedClass(Cart.class)
			.buildSessionFactory();
	
	public OrderItemDAOImp() {}
	
	@Override
	@Transactional
	public void addOrderItems(OrderItem orderItem) {
		Session session = sessionFactory.openSession();
		session.save(orderItem);
		session.close();	
	}
}
