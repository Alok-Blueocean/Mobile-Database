package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.DAO.ProductDAO;
import com.example.Entity.Admin;
import com.example.Entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController	
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	@Autowired
	Admin admin;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	public ProductController() {}

	@PostMapping("/product/add/")
	public void addProductToRepo(@RequestBody Product prNode) {
		productDAO.addProduct(prNode);
	}
	@GetMapping("/product/delete/{id}")
	public void deleteProductToRepo(@PathVariable int id) {
		Product product = productDAO.getProductById(id);
		productDAO.deleteProduct(product.getId());
	}
	/*
	 * Issue of Lazy Initializer 
	 * https://vladmihalcea.com/the-best-way-to-handle-the-lazyinitializationexception/
	 * SELECT * FROM ProjectEmployee pe JOIN FETCH pe.employee e JOIN FETCH e.person
	 */
	@GetMapping("/product/get/")
	@ResponseBody
	public ResponseEntity<List<Product>> getAllProducts() throws JsonProcessingException {
		return new ResponseEntity<List<Product>>(productDAO.getAllProducts(),HttpStatus.OK);
	}
	@GetMapping("/product/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product product = productDAO.getProductById(id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
}