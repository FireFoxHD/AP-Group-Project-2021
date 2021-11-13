package models;


public class Customer {
	private String id;
	private String firstname;
	private String lastname;
	private double balance;
	
	
	public Customer() {
		this.id = "";
		this.firstname = "";
		this.lastname = "";
		this.balance = 0.0;
	}
	
	public Customer(String id, String firstname, String lastname, String pass, double bal) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
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
		return "ID: " + this.id + "\tName: " + this.firstname +" "+this.lastname + "\t bal: "+ this.balance;
	}

	
}
