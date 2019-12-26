package com.example.hiber;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example.Entity.Customer;

public class Update {

	public Update() {}
	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.setPhone(3);
		customer.setName("Ranjan");
		Customer customer5 = new Customer();
		customer.setPhone(3);
		customer.setName("Ranjan");
		SessionFactory factory = new org.hibernate.cfg.Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").getResultList();
		customers.forEach(System.out::println);
		Customer customer2 = session.get(Customer.class,customer.getPhone());
		Customer customer3 = session.get(Customer.class,Long.valueOf(2));
		System.out.println(customer2);
		customer2.setName("Ram");
		session.delete(customer3); //delete value
		session.getTransaction().commit();
	}
}
