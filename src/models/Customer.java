package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;

public class Customer {
	private String id;
	private String firstname;
	private String lastname;
	private String password;
	private double balance;
	
	
	public Customer() {
		this.id = "";
		this.firstname = "";
		this.lastname = "";
		this.password = "";
		this.balance = 0.0;
	}
	
	public Customer(String id, String firstname, String lastname, String pass, double bal) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = pass;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tName: " + this.firstname +" "+this.lastname + "\t pass: "+ this.password + "\t bal: "+ this.balance;
	}

	// CRUD Operations

	
}
