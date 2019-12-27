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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {
	
	public Product() {}
	protected String nameString;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	protected long price;
	@JoinColumn(name = "product_details_id")
	@OneToOne(cascade = CascadeType.ALL)
	private ProductDetails productDetails;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})
	@JsonIgnore
	@JoinTable(name = "product_agent",
	joinColumns = @JoinColumn(name  = "product_id"),
	inverseJoinColumns = @JoinColumn(name ="shipping_agent_id"))
	private List<ShippingAgent> shippingAgents;
	
	public List<ShippingAgent> getShippingAgents() {
		return shippingAgents;
	}
	public void setShippingAgents(List<ShippingAgent> shippingAgents) {
		this.shippingAgents = shippingAgents;
	}
	public void addShippingAgent(ShippingAgent shippingAgent) {
		if (shippingAgents==null) {
			shippingAgents = new ArrayList<ShippingAgent>();
		}
		shippingAgents.add(shippingAgent);
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getId() {
		return id;
	}
	public void setId(int uniqueNoString) {
		this.id = uniqueNoString;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [nameString=" + nameString + ", uniqueNoString=" + id + ", price=" + price
				+  "]";
	}
	public ProductDetails getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(ProductDetails pDetails) {
		productDetails = pDetails;
	}
	public Product(ProductBuilder builder) {
		
		this.nameString = builder.nameString;
		this.price = builder.price;
		this.id = builder.id;
	}

public class ProductBuilder {
		
		private String nameString;
		private int id;
		private long price;
		
		public ProductBuilder() {}
		public String getNameString() {
			return nameString;
		}
		public ProductBuilder setNameString(String nameString) {
			this.nameString = nameString;
			return this;
		}
		public int getUniqueNoString() {
			return id;
		}
		public ProductBuilder setUniqueNoString(int uniqueNoString) {
			this.id = uniqueNoString;
			return this;
			
		}
		public long getPrice() {
			return price;
		}
		public ProductBuilder setPrice(long price) {
			this.price = price;
			return this;
		}
		public Product build() {
			Product product = new Product(this);
			return product;
		}	
	}
	public static void main(String[] args) {
		ProductDetails productd = new ProductDetails().new ProductDetailsBuilder()
				.setTypeString("phone")
				.build();
		Product product = new Product().new ProductBuilder()
				.setUniqueNoString(1)
				.setNameString("nokia 2662")
				.setPrice(50000)
				.build();
		/* If we make the Product builder class static then initialize like this */
		
		System.out.println(product);
		
	}
}
	