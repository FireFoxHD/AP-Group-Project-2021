package models;

import java.io.Serializable;

public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String phoneNumber;
	private double balance;
	
	
	public Customer() {
		this.id = "";
		this.firstname = "";
		this.lastname = "";
		this.setEmail("");
		this.setPhoneNumber("");
		this.balance = 0.0;
	}
	
	public Customer(String id, String firstname, String lastname, String email, String phoneNumber, double bal) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.balance = bal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tName: " + this.firstname +" "+this.lastname + "\tEmail: " + this.email+"\tPhone: " +this.phoneNumber +"\t bal: "+ this.balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
