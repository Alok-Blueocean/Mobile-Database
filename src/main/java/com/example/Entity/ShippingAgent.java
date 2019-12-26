package com.example.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "agent")
public class ShippingAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameString;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})
	@JsonIgnore
	@JoinTable(name = "product_agent",
				joinColumns = @JoinColumn(name  = "shipping_agent_id"),
				inverseJoinColumns = @JoinColumn(name ="product_id"))
	private List<Product> products;
	
	public ShippingAgent() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
 public void addProduct(Product product) {
	 if (products==null) {
		products = new ArrayList<Product>();
	}
	 products.add(product);
	 
 }

@Override
public String toString() {
	return "ShippingAgent [id=" + id + ", nameString=" + nameString + ", products=" + products + "]";
}
 
 }

