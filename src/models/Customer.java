package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import dbconnection.DbConnect;

public class Customer {
	private String id;
	private String firstname;
	private String lastname;
	private String password;
	private double balance;
	
	private Statement stmt = null;
	private ResultSet result = null;
	private int numOfRowsAffected = 0;
	private Connection connection = DbConnect.getConnection();
	
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

	// Create
	public void create() {
		String insertSql = "INSERT INTO equipment_rental.customer VALUES ('" + getId() + "', '" + getFirstname() + "','" + getLastname() + "','" + getBalance() + "')";
		
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer created", "Customer Creation",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			createPassword(getId(), getPassword());
			
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
		}

	}

	// Create Password
	public void createPassword(String id, String password) {
		String insertSql = "INSERT INTO equipment_rental.hash VALUES ('" + id + "', '" + password+"')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Password entry created", "Password Creation",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
		}

	}

	// Select all
	public void readAll() {
		String selectSql = "SELECT * FROM equipment_rental.customer WHERE 1 = 1";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("id");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String balance = result.getString("balance");

				System.out.println("ID: " + id + "\tName: " + firstname + " " + lastname + "\tBalance:" + balance);
			}
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
		}

	}

	// Update Firstname
	public void updateFirstname(String id, String firstname) {
		String updateSQL = "UPDATE equipment_rental.customer SET id='" + firstname+ "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer record has been updated", "Customer Update",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
		}

	}
	
	// Update Lastname
	public void updateLastname(String id, String lastname) {
		String updateSQL = "UPDATE equipment_rental.customer SET id='" + lastname + "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer record has been updated", "Customer Update",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
		}

	}
	
	// Update
	public void updateBalance(String id, float balance) {
		String updateSQL = "UPDATE equipment_rental.customer SET id='" + getId() + "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer record has been updated", "Customer Update",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
		}
		
	}

	// Delete
	public void delete(String id) {
		String deleteSQL = "DELETE FROM equipment_rental.customer WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer record deleted", "Customer Delete",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error Deleting: " + e.getMessage());
		}
	}
}
