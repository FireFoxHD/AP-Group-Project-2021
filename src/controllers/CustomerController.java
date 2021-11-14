package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;
import models.Customer;
import models.Employee;
import models.Role;

public class CustomerController {
	
	private static Statement stmt;
	private static ResultSet result;
	private static int numOfRowsAffected;
	private static Connection connection;
	private static final Logger logger = LogManager.getLogger(Customer.class);
	
    public CustomerController() {
    	CustomerController.stmt = null;
    	CustomerController.result = null;
    	CustomerController.numOfRowsAffected = 0;
    	CustomerController.connection = DbConnect.getConnection();
    }

	// Create
	public static void create(String id, String firstname, String lastname, String email, String phoneNumber, String pass) {
		String insertSql = "INSERT INTO grizzlydb.customer VALUES ('" + id + "', '" + firstname + "','" + lastname + "','"+ email + "','"+ phoneNumber +"','" + 0.0 + "')";
		
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer created", "Customer Creation",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Customer Record Created");
			}
			new PasswordController();
			PasswordController.createPassword(id, pass);
			
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
			logger.error("SQL Error, Customer Record Not Created: " +e.getMessage());
		}

	}

	//Read
	public static Customer read(String id) {
		String selectSql = "SELECT * FROM grizzlydb.customer WHERE id =" + id;
		Customer cust = null;
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("email");
				String phoneNumber = result.getString("phoneNumber");
				double balance = result.getDouble("balance");
				
				cust = new Customer(id,firstname,lastname, email, phoneNumber, balance);

				logger.info("Employee Record Accessed For " +id);
			}
		} catch (SQLException e) {
			System.err.println("Error Selecting: " + e.getMessage());
			logger.error("Unable To Read Employee Record For "+id+ "\n" +e.getMessage());
		}
		
		return cust;
	}
		

	// Select all
	public static ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String selectSql = "SELECT * FROM grizzlydb.customer WHERE 1 = 1";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("id");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("email");
				String phoneNumber = result.getString("phoneNumber");
				double balance = result.getDouble("balance");
				
				customers.add(new Customer(id,firstname,lastname, email, phoneNumber, balance));
				System.out.println("ID: " + id + "\tName: " + firstname + " " + lastname + "\tBalance:" + balance);
			}
			logger.info("Customer Records Accessed");
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
			logger.error("Could Not Read Customer Records: " +e.getMessage());
		}
		return null;

	}

	// Update all (except password)
	public static void update(String id, String firstname, String lastname, String email, String phoneNumber, double bal) {
		String updateSQL = "UPDATE grizzlydb.customer SET id='" + firstname+ "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer record has been updated", "Customer Update",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("First Name Updated For Customer " +id);
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
			logger.error("Error Updating First Name For Customer Record " +id+"\n"+e.getMessage());
		}

	}
	
	// Update Balance
	public static void updateBalance(String id, float balance) {
		String updateSQL = "UPDATE grizzlydb.customer SET id='" + id + "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer record has been updated", "Customer Update",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Balance Updated For Customer " +id);
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
			logger.error("Error Updating Balance For Customer Record " +id+"\n"+e.getMessage());
		}
		
	}

	
	// Delete
	public static void delete(String id) {
		String deleteSQL = "DELETE FROM grizzlydb.customer WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer record deleted", "Customer Delete",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Customer Record "+id+" Was Deleted");
			}
		} catch (SQLException e) {
			System.err.println("Error Deleting: " + e.getMessage());
			logger.error("Error Deleting Customer Record " +id+"\n"+e.getMessage());
		}
	}
}
