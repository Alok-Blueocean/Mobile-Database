package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example.Entity.Address;
import com.example.Entity.Customer;

public class AddtoManyRetriev {

	public AddtoManyRetriev() {}
	public static void main(String[] args) {
		SessionFactory factory = new org.hibernate.cfg.Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
		
		session.beginTransaction();
		
		long id=1;
		Customer customer = session.get(Customer.class, id);
		System.out.println(customer);
		System.out.println(customer.getAddresses());
		/*
		int id=1;
		Address address  = session.get(Address.class, id);
		System.out.println(address.getCustomer());
		*/
		session.getTransaction().commit();
		
		/*
		 * To verify Eager Lazy Loader
		 * 
		 */
		System.out.println(customer);
		System.out.println(customer.getAddresses());
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
