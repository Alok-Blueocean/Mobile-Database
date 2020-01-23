package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example.Entity.Customer;

public class App {

	public App() {}
	public static void main(String[] args) {

		Customer customer = new Customer();
//		customer.setPhone(95383722);
		customer.setName("Ranjan");

		/*
				org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration()
																						.configure().
																						addAnnotatedClass(Customer.class);
				SessionFactory sessionFactory = configuration.buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction txTransaction = session.beginTransaction();
//				session.save(customer);
//				txTransaction.commit();
				
				Customer customer2 = txTransaction.get(Customer.class,customer.getPhone());
				System.out.println(customer2);
				customer2.setPhone(2552);
				txTransaction.commit();
				List<Customer> customers = session.createQuery("from Customer")
						.getResultList();
				customers.forEach(System.out::println);
				
		*/
		
		SessionFactory factory = new org.hibernate.cfg.Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {			
			session.beginTransaction();
			session.save(customer);					

			session.getTransaction().commit();

			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
	}


}
