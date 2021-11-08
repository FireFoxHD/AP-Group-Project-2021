package com;

import models.*;

public class Main {

	public static void main(String[] args) {
		
		Customer cust = new Customer("001", "rick","grimes", "password",5000.00);
		System.out.println(cust.getFirstname());
		
	}


}
