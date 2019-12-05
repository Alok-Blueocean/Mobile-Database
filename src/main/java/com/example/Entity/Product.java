package com.example.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Entity.ProductDetails.ProductDetailsBuilder;

@Component
public class Product {
	
	protected String nameString;
	protected String uniqueNoString;
	protected long price;
	
	@Autowired
	private ProductDetails productDetails;
	
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getUniqueNoString() {
		return uniqueNoString;
	}
	public void setUniqueNoString(String uniqueNoString) {
		this.uniqueNoString = uniqueNoString;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	

	
	@Override
	public String toString() {
		return "Product [nameString=" + nameString + ", uniqueNoString=" + uniqueNoString + ", price=" + price
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
		this.uniqueNoString = builder.uniqueNoString;
	}
	public Product() {}
public class ProductBuilder {
		
		private String nameString;
		private String uniqueNoString;
		private long price;
		
		public ProductBuilder() {}

		public String getNameString() {
			return nameString;
		}

		public ProductBuilder setNameString(String nameString) {
			this.nameString = nameString;
			return this;
		}

		public String getUniqueNoString() {
			return uniqueNoString;
		}

		public ProductBuilder setUniqueNoString(String uniqueNoString) {
			this.uniqueNoString = uniqueNoString;
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
				.setUniqueNoString("1rv")
				.setNameString("nokia 2662")
				.setPrice(50000)
				.build();
		/* If we make the Product builder class static then initialize like this */
		
		System.out.println(product);
		
	}
}
	