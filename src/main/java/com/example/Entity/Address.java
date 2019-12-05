package com.example.Entity;

import org.springframework.stereotype.Component;

@Component
public class Address {

	protected long houseNo;
	protected String street;
	protected String landmark;
	protected long pinCode;
	public Address() {
	}
	public Address(long houseNo, String street, String landmark, long pinCode) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.landmark = landmark;
		this.pinCode = pinCode;
	}

}
