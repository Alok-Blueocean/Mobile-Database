package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example.Entity.Product;
import com.example.Entity.ProductDetails;

public class OneToManyRetrieve {

	public OneToManyRetrieve() {}
	public static void main(String[] args) {
		
		SessionFactory factory = new org.hibernate.cfg.Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(ProductDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
		
		session.beginTransaction();
		int id=1;
		ProductDetails address = session.get(ProductDetails.class, id);
		System.out.println(address);
		System.out.println(address.getProduct());
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
