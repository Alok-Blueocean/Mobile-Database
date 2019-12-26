package com.example.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.Product;
import com.example.Entity.ProductDetails;
import com.example.Entity.Review;
import com.example.Entity.ShippingAgent;


@Repository(value = "productDao")

public class ProductDAOImpl implements ProductDAO {

	SessionFactory factory = new org.hibernate.cfg.Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(ProductDetails.class)
			.addAnnotatedClass(Review.class)
			.addAnnotatedClass(ShippingAgent.class)
			.buildSessionFactory();
	public ProductDAOImpl() {
		
	}
	@Transactional
	public void addProduct(Product p) {
		Session session = factory.openSession();
		session.save(p);
		session.close();
	}
	@Override
	@Transactional
	public void editProduct(Product p) {
		Session session = factory.openSession();
		session.saveOrUpdate(p);
		session.close();
	}

	public void deleteProduct(int id) {
		
	
		Session session = factory.openSession();
		Transaction transactional = session.getTransaction();
		transactional.begin();
		Product product = (Product) session.get(Product.class, id);
		
		Query query = session.createQuery("delete Product where id=?0");
		query.setParameter(0,product.getId());
		 
		int result = query.executeUpdate();
		 
		if (result > 0) {
		    System.out.println("Expensive products was removed");
		}
//		session.delete(product);
//		session.flush();
		transactional.commit();
		session.close();
		System.out.println(product);
	}
	@Transactional
	@Override
	public List<Product> getAllProducts() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.getResultList();
		session.close();
		return products;
	}
	@Override
	@Transactional
	public Product getProductById(int id) {
		Session session = factory.openSession();
		org.hibernate.query.Query query = session.createQuery("from Product where id=?0");
		query.setInteger(0, id);
		Product product = (Product) query.uniqueResult();
		session.close();
		return product;
	}
}
