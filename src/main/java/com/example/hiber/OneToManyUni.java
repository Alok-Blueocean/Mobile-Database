package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.Entity.Product;
import com.example.Entity.ProductDetails;
import com.example.Entity.Review;

public class OneToManyUni {

	public OneToManyUni() {
		// TODO Auto-generated constructor stub
	}
public static void main(String[] args) {
	ProductDetails productd = new ProductDetails();
	productd.setTypeString("phone");
	productd.setPrice(1000);
	
	productd.addReviews(new Review("Great course ... loved it!"));
	productd.addReviews(new Review("Cool course, job well done"));
	productd.addReviews(new Review("What a dumb course, you are an idiot!"));
	
	Product product1 = new Product();
	product1.setNameString("Nokia 2033");
	product1.setProductDetails(productd);
	
//	Product product2 = new Product().new ProductBuilder()
//			.setNameString("Nokia 2133")
//			.setPrice(1200)
//			.build();
//	product2.setProductDetails(productd);
	
	SessionFactory factory = new org.hibernate.cfg.Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(ProductDetails.class)
			.addAnnotatedClass(Review.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();
	session.beginTransaction();
	
	session.save(product1);
//	session.save(product2);
	session.getTransaction().commit();
}
}
