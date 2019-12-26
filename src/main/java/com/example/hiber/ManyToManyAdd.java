package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.Entity.Product;
import com.example.Entity.ProductDetails;
import com.example.Entity.Review;
import com.example.Entity.ShippingAgent;

public class ManyToManyAdd {

	public ManyToManyAdd() {
		// TODO Auto-generated constructor stub
	}
public static void main(String[] args) {
	SessionFactory factory = new org.hibernate.cfg.Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(ProductDetails.class)
			.addAnnotatedClass(ShippingAgent.class)
			.addAnnotatedClass(Review.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	try {
		
	
	session.beginTransaction();
//	Product product = new Product();
//	product.setNameString("Flipflop");
//	product.setPrice(3000);
//	session.save(product);
//	int id =9;
//	ShippingAgent shippingAgent = session.get(ShippingAgent.class, id);
//	System.out.println(shippingAgent);
	int id =2;
	Product product = session.get(Product.class, id);
	System.out.println(product);
//	System.out.println(shippingAgent);
	
//	shippingAgent.addProduct(product);
	ShippingAgent shippingAgent = new ShippingAgent();
	shippingAgent.setNameString("Cloud-X");
//	
	ShippingAgent shippingAgent1 = new ShippingAgent();
	shippingAgent1.setNameString("Delux");
	
	shippingAgent.addProduct(product);
	shippingAgent1.addProduct(product);
	
	session.save(shippingAgent);
	session.save(shippingAgent1);
	
	session.getTransaction().commit();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		session.close();
		factory.close();
	}
	
}
}
