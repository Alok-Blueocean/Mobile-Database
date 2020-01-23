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
public class OrderDAOImpl implements OrderDAO
{
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

	public OrderDAOImpl() {}
	
	@Override
	@Transactional
	public void addOrder(Order order) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(order);
		session.close();
	}
	@Override
	@Transactional
	public Order getOrderById(long id) {
		Session session = sessionFactory.openSession();
		org.hibernate.query.Query query = session.createQuery("from Productorder where id=?0");
		query.setLong(0, id);
		Order order = (Order) query.uniqueResult();
		session.close();
		System.out.println("orders");
		System.out.println(order.getOrdersItems());
		return order;
	}
}
