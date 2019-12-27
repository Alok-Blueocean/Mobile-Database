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
	public void addProducts() {}
}
