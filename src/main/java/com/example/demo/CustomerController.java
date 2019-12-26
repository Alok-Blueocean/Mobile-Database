package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.Entity.Customer;
import com.example.Entity.Invoice;
import com.example.Entity.Product;
import com.example.Entity.ProductDetails;

@RestController
public class CustomerController {

	@Autowired
	public Admin admin;
	
	@Autowired
	public Customer customer;	
	@Autowired
	public Invoice invoice;	
	
	public CustomerController() {}
	
	@RequestMapping(value = "/customer/get",method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<List<Product>>(admin.getProducts(),HttpStatus.OK);
	}
	@RequestMapping(value = "/customer/get/{uniqueId}",method = RequestMethod.GET)
	public ResponseEntity<ProductDetails> getProducts(@PathVariable String uniqueId){
		
	
		return new ResponseEntity<ProductDetails>(HttpStatus.BAD_REQUEST);
	}
	@RequestMapping(value = "/customer/get/{uniqueId}/buy/{quantity}",method = RequestMethod.GET)
	public ResponseEntity<Invoice> orderProducts(@PathVariable String uniqueId,
			@PathVariable int quantity){
		
	
		//new ResponseEntity<Invoice>(invoice, HttpStatus.OK)
		return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
		}
		
	
}
