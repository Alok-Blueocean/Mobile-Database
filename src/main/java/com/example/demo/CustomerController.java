package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.CustomerDAO;
import com.example.DAO.OrderDAO;
import com.example.DAO.OrderItemDAO;
import com.example.DAO.ProductDAO;
import com.example.Entity.Address;
import com.example.Entity.Admin;
import com.example.Entity.Customer;
import com.example.Entity.Order;
import com.example.Entity.OrderItem;
import com.example.Entity.Product;
import com.example.Entity.ProductDetails;
import com.example.Service.OrderService;

@RestController
public class CustomerController {

	@Autowired
	public Admin admin;
	
	@Autowired
	ProductDAO productDAO;
 	@Autowired
	OrderService orderService;
 	
 	@Autowired
 	OrderItemDAO orderItemDAO;
 	
	@Autowired
 	OrderDAO orderDAO;
	
	@Autowired
 	CustomerDAO customerDao;
	
 	@Autowired
 	Customer customer;
	@Autowired
	public Order order;	
	
	public CustomerController() {}
	
	@RequestMapping(value = "/customer/get",method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<List<Product>>(productDAO.getAllProducts(),HttpStatus.OK);
	}
	@RequestMapping(value = "/customer/get/{uniqueId}",method = RequestMethod.GET)
	public ResponseEntity<ProductDetails> getProducts(@PathVariable int uniqueId){
		Product product = productDAO.getProductById(uniqueId);
		System.out.println(product);
		return new ResponseEntity<ProductDetails>(product.getProductDetails(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/get/{uniqueId}/buy/{quantity}",method = RequestMethod.GET)
	public void orderProducts(@PathVariable int uniqueId,
			@PathVariable int quantity){
		customer = customerDao.getCustomerbyPhone(1);
//		customerDao.setCustomer(customer);
	
		Product product = productDAO.getProductById(uniqueId);
		Order order = new Order();
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(product);
		orderItem.setQuantity(2);
		order.addOrderItem(orderItem);
//		orderDAO.addOrder(order);
		customerDao.setOrder(customer.getPhone(),order);
//		customerDao.setCustomer(customer);
//		orderService.addProductOrder(product, quantity);
//		long id = customer.getOrder().getOrderId();
		System.out.println("id.............");
//		long id=order.getCustomer().getOrder().getOrderId();
		}
}
