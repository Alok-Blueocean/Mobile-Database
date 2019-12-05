package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.Entity.Product;
import com.example.Entity.ProductDetails;
import com.example.Entity.ProductDetails.ProductDetailsBuilder;

@RestController
public class MBController {

	@Autowired
	public Admin admin;
	
	public MBController() {
	}
	@RequestMapping(value = "/admin/get",method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<List<Product>>(admin.getProducts(),HttpStatus.OK);
		
	}

	@RequestMapping(value = "/add")
	public void addProducts() {
		
		ProductDetails productd = new ProductDetails().new ProductDetailsBuilder()
				.setTypeString("phone")
				.setPrice(1000)
				.build();
		Product product1 = new Product().new ProductBuilder()
				.setUniqueNoString("Nok1")
				.setNameString("Nokia 2033")
				.setPrice(1000)
				.build();
		product1.setProductDetails(productd);
		Product product2 = new Product().new ProductBuilder()
				.setUniqueNoString("Nok2")
				.setNameString("Nokia 2133")
				.setPrice(1200)
				.build();
		product2.setProductDetails(productd);
		admin.addProduct(product1);
		admin.addProduct(product2);
	}
}
