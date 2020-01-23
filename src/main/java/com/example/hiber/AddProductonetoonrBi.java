package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.Entity.Customer;
import com.example.Entity.Product;
import com.example.Entity.ProductDetails;

public class AddProductonetoonrBi {

	public AddProductonetoonrBi() {
		// TODO Auto-generated constructor stub
	}
public static void main(String[] args) {
	
	ProductDetails productd = new ProductDetails();
	productd.setTypeString("phone");
	productd.setPrice(1000);
	
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
			.addAnnotatedClass(Customer.class)
			.addAnnotatedClass(ProductDetails.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();
	session.beginTransaction();
	
	session.save(product1);
//	session.save(product2);
	session.getTransaction().commit();
}
}
