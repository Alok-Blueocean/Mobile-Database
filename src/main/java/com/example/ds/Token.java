package com.example.ds;

public class Token {

	public Token() {
		// 9538382299
	}
public static void main(String[] args) {
	String string= "saveChangesInTheEditor";
	String[] tokenStrings = string.trim().split("[A-Z]");
	System.out.println(tokenStrings.length);
	for (int i = 0; i < tokenStrings.length; i++) {
		System.out.println(tokenStrings[i]);
	}
	
}
}
