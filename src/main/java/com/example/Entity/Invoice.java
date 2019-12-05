package com.example.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Invoice {

	public String billNoString;
	protected String customerNameString;
	private long customerPhoneString;
	public Double totalAmountDouble;
	
	@Autowired
	private Order order;
	
	public Invoice() {}
	public Invoice(Customer customer,Order order) {
		billNoString = "Bill123";
		customerNameString = "alok";//customer.getName();
		customerPhoneString = 95383822;//customer.getPhone();
		totalAmountDouble = order.getTotalAmount();
	}
	@Override
	public String toString() {
		return "Invoice [billNoString=" + billNoString + ", customerNameString=" + customerNameString
				+ ", customerPhoneString=" + customerPhoneString + ", totalAmountDouble=" + totalAmountDouble + "]";
	}
	
	public void createInvoice() {
		billNoString = "Bill123";
		customerNameString = "alok";//customer.getName();
		customerPhoneString = 95383822;//customer.getPhone();
		totalAmountDouble = order.getTotalAmount();
	}
}
