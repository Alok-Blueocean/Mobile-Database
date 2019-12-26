package com.example.DAO;

import java.util.List;

import com.example.Entity.Product;
import com.example.hiber.AddProductonetoonrBi;

public interface ProductDAO {
	
	public void addProduct(Product p);
	public void editProduct(Product p);
	public void deleteProduct(int id);
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	
}
