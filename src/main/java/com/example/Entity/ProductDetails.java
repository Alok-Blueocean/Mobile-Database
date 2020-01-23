package com.example.Entity;

import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product_details")
public class ProductDetails extends Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@OneToOne(mappedBy = "productDetails",cascade = CascadeType.ALL)
	@JsonIgnore
	private Product product;
	
	private String typeString;
	private Date addedDate;
	private Period Gurantee;
	
	@JoinColumn(name = "product_review_id")
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public void addReviews(Review review) {
		if (reviews ==null) {
			reviews = new ArrayList<Review>();
		}
		reviews.add(review);
	}
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

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductDetails(ProductDetailsBuilder builder) {
		
		this.productName = builder.nameString;
		this.addedDate = builder.addedDate;
		this.Gurantee = builder.Gurantee;
		this.productPrice = builder.price;
		this.id = builder.id;
		this.typeString = builder.typeString;
	}
	
	
	@Override
	public String toString() {
		return "ProductDetails [typeString=" + typeString + ", addedDate=" + addedDate + ", Gurantee=" + Gurantee
				+ ", tagSet="  + ", nameString=" + productName + ", uniqueNoString=" + id
				+ ", price=" + productPrice + "]";
	}


public class ProductDetailsBuilder extends ProductBuilder {
		
		private String nameString;
		private int id;
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

		public int getId() {
			return id;
		}

		public ProductDetailsBuilder setUniqueNoString(int id) {
			this.id = id;
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
//		ProductDetails product = new ProductDetails().new ProductDetailsBuilder()
//				.setUniqueNoString("1rv")
//				.setNameString("nokia 2662")
//				.setPrice(50000)
//				.setTypeString("phone")
//				.build();
		/* If we make the Product builder class static then initialize like this */
		
//		System.out.println(product);
		
	}
}

