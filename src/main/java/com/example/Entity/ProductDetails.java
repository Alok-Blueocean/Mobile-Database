package com.example.Entity;

import java.time.Period;
import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ProductDetails extends Product {

	private String typeString;
	private Date addedDate;
	private Period Gurantee;
	private Set<String> tagSet = null;
	public ProductDetails() {}
	public String getTypeString() {
		return typeString;
	}
	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public Period getGurantee() {
		return Gurantee;
	}
	public void setGurantee(Period gurantee) {
		Gurantee = gurantee;
	}
	public Set<String> getTagSet() {
		return tagSet;
	}
	public void setTagSet(Set<String> tagSet) {
		this.tagSet = tagSet;
	}
	public ProductDetails(ProductDetailsBuilder builder) {
		
		this.nameString = builder.nameString;
		this.addedDate = builder.addedDate;
		this.Gurantee = builder.Gurantee;
		this.price = builder.price;
		this.tagSet = builder.tagSet;
		this.uniqueNoString = builder.uniqueNoString;
		this.typeString = builder.typeString;
	}
	
	
@Override
	public String toString() {
		return "ProductDetails [typeString=" + typeString + ", addedDate=" + addedDate + ", Gurantee=" + Gurantee
				+ ", tagSet=" + tagSet + ", nameString=" + nameString + ", uniqueNoString=" + uniqueNoString
				+ ", price=" + price + "]";
	}


public class ProductDetailsBuilder extends ProductBuilder {
		
		private String nameString;
		private String uniqueNoString;
		private long price;
		private String typeString;
		private Date addedDate;
		private Period Gurantee;
		private Set<String> tagSet = null;
		
		public ProductDetailsBuilder() {}

		public String getNameString() {
			return nameString;
		}

		public ProductDetailsBuilder setNameString(String nameString) {
			this.nameString = nameString;
			return this;
		}

		public String getUniqueNoString() {
			return uniqueNoString;
		}

		public ProductDetailsBuilder setUniqueNoString(String uniqueNoString) {
			this.uniqueNoString = uniqueNoString;
			return this;
			
		}

		public long getPrice() {
			return price;
		}

		public ProductDetailsBuilder setPrice(long price) {
			this.price = price;
			return this;
		}

		public String getTypeString() {
			return typeString;
		}

		public ProductDetailsBuilder setTypeString(String typeString) {
			this.typeString = typeString;
			return this;
		}

		public Date getAddedDate() {
			return addedDate;
		}

		public ProductDetailsBuilder setAddedDate(Date addedDate) {
			this.addedDate = addedDate;
			return this;
		}

		public Period getGurantee() {
			return Gurantee;
		}

		public ProductDetailsBuilder setGurantee(Period gurantee) {
			this.Gurantee = gurantee;
			return this;
		}

		public Set<String> getTagSet() {
			return tagSet;
		}

		public ProductDetailsBuilder setTagSet(Set<String> tagSet) {
			this.tagSet = tagSet;
			return this;
		}
		public ProductDetails build() {
			ProductDetails product = new ProductDetails(this);
			return product;
			
		}
		
	}

	public static void main(String[] args) {
		ProductDetails product = new ProductDetails().new ProductDetailsBuilder()
				.setUniqueNoString("1rv")
				.setNameString("nokia 2662")
				.setPrice(50000)
				.setTypeString("phone")
				.build();
		/* If we make the Product builder class static then initialize like this */
		
		System.out.println(product);
		
	}
}

