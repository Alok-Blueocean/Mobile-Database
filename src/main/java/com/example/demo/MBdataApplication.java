package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.DAO.CustomerDAO;
import com.example.DAO.OrderDAO;
import com.example.DAO.ProductDAO;
import com.example.Entity.Customer;
import com.example.Entity.Product;
import com.example.Entity.ProductDetails;
import com.example.Entity.ProductDetails.ProductDetailsBuilder;

@SpringBootApplication(scanBasePackages = "com.example.demo,com.example.aspect,com.example.Entity,com.example.DAO,com.example.Service")
@EnableAspectJAutoProxy
public class MBdataApplication implements CommandLineRunner{

	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	OrderDAO orderDAO;

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext cnfContext = 
				SpringApplication.run(MBdataApplication.class, args);
		ProductDetailsBuilder productDetailsBuilder = new ProductDetails()
				.new  ProductDetailsBuilder().setPrice(1000)
				.setTypeString("smartphone");
		ProductDetails productDetails = new ProductDetails(productDetailsBuilder);
		Product product = (Product) cnfContext.getBean("product");
		product.setNameString("Nokia");
		product.getProductDetails();
	}
	@Override
	public void run(String... args) throws Exception {
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println(user.getName());
		
		Customer customer = new Customer("Alok", 9538);
//		customer.addAddress(new Address(2343, "vrindavan",
//				"keshighat", 801104));
//		customerDAO.setCustomer(customer);
		ProductDetailsBuilder productDetailsBuilder = new ProductDetails().new  ProductDetailsBuilder().setPrice(1000)
		.setTypeString("smartphone");
		ProductDetails productDetails = new ProductDetails(productDetailsBuilder);
		Product product = new Product().new ProductBuilder().setNameString("Nokia").build();
//		product.setNameString("Nokia");
//		product.setProductDetails(productDetails);
		productDAO.addProduct(product);
//		Customer customer2 = customerDAO.getCustomerbyPhone(1);
//		System.out.println(customer2);
//		OrderItem orderItem = new OrderItem();
//		orderItem.setProduct(productDAO.getProductById(2));
//		orderItem.setQuantity(3);
//		Order order = new Order();
//		order.setOrdersItems(new ArrayList<OrderItem>(Arrays.asList(orderItem)));
//		customer.setOrder(order);
//		customerDAO.setCustomer(customer);
//		orderDAO.addOrder(order);
//		customer2.setOrder(orderDAO.getOrderById(1));
//		customerDAO.setOrder(customer2.getPhone(), order);
//		System.out.println(orderDAO.getOrderById(id));
		
	}
}
