package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.Entity.Address;
import com.example.Entity.Customer;

public class AddwithOneToMany {

	public AddwithOneToMany() {
		// TODO Auto-generated constructor stub
	}
public static void main(String[] args) {
	
	Address address = new Address(2343, "Vrindavan colony", "tribhuvan library", 801104);
//	Customer customer = new Customer("mohan",953);
//	customer.addAddress(address);
	
	Address address2 = new Address(234, "dwarka colony", "pes library", 500049);
//	Customer customer2 = new Customer("Alok",9538);
//	customer.addAddress(address2);
	
	SessionFactory factory = new org.hibernate.cfg.Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Customer.class)
			.addAnnotatedClass(Address.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();
	session.beginTransaction();
	Customer customer = new Customer("mohan",953);
	session.save(customer);
	session.getTransaction().commit();
	session = factory.getCurrentSession();
	session.beginTransaction();
	long id = 1;
	Customer cucCustomer = session.get(Customer.class, id);
	cucCustomer.addAddress(address);
	cucCustomer.addAddress(address2);
	session.save(address);
	session.save(address2);
	session.save(cucCustomer);
//	session.save(customer2);
	session.getTransaction().commit();
}
}
