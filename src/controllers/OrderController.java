package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;
import models.Order;
import models.Status;

public class OrderController {
	
	private Statement stmt;
	private ResultSet result;
	private int numOfRowsAffected;
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(Order.class);
	
	public OrderController() {
		this.stmt = null;
    	this.result = null;
    	this.numOfRowsAffected = 0;
    	this.connection = DbConnect.getConnection();
	}
	// CRUD Operations

	// create
	public void create(String id, String custId, String empId, Status status, Date dateOfReturn) {
		Date dateOfRental = new Date(System.currentTimeMillis());
		
		String insertSql = "INSERT INTO equipment_rental.order VALUES ('" + id + "', '" + custId + "','"
				+ empId + "','" + status.name()+ "','" + dateOfRental + "','" + dateOfReturn + "')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Order created", "Order Creation", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Order Record "+id+" Created");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
			logger.error("Unable To Create Order Record "+id+", "+e.getMessage());
		}

	}

	// select all
	public void readAll() {
		String selectSql = "SELECT * FROM equipment_rental.order WHERE 1 = 1";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("id");
				String customerId = result.getString("custId");
				String employeeId = result.getString("empId");
				String Status = result.getString("Status");
				Date dateOfRental = result.getDate("dateOfRental");
				Date dateOfReturn = result.getDate("dateOfReturn");


				System.out.println("ID: " + id + "\n\tCustomer ID: " + customerId + "\n\tEmployee ID: " + employeeId
						+ "\n\tDate of Rental:" + dateOfRental + "\n\tDate of Rental:" + dateOfReturn);
			}
			logger.info("Order Records Accessed");
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
			logger.error("Unable To Access Order Records, "+e.getMessage());
		}

	}

	// update 
	//TODO complete updateALl
	public void update(String id, String customerId, String employeeId, Status status, Date dateOfReturn) {
		String updateSQL = "UPDATE equipment_rental.order SET id='" + id + "',empId = '"+employeeId+"', WHERE id = '" + id+"'";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Order has been updated", "Order Update",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Order Record "+id+" Updated");
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
			logger.error("Unable To Update Order Record "+id+", "+e.getMessage());
		}

	}

	// delete
	public void delete(String id) {
		String deleteSQL = "DELETE FROM equipment_rental.order WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Order deleted", "Order Delete", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Order Record "+id+" Deleted");
			}
		} catch (SQLException e) {
			System.err.println("Error Deleting: " + e.getMessage());
			logger.error("Unable To Delete Order Record "+id+", "+e.getMessage());
		}
	}


	
}
