package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;
import models.Order;
import models.Status;

public class OrderController {
	
	private static Statement stmt;
	private static ResultSet result;
	private static int numOfRowsAffected;
	private static Connection connection;
	private static final Logger logger = LogManager.getLogger(Order.class);
	
	public OrderController() {
		OrderController.stmt = null;
    	OrderController.result = null;
    	OrderController.numOfRowsAffected = 0;
    	OrderController.connection = DbConnect.getConnection();
	}
	// CRUD Operations

	// create
	
	//TODO think about adding an calling the itemcontroller create and passing it items to create an entry in the orderItems table
	public static void create(String id, String custId, String empId, Date dateOfReturn) {
		Date dateOfRental = new Date(System.currentTimeMillis());
		Status status = models.Status.PENDING;
		
		String insertSql = "INSERT INTO grizzlydb.order VALUES ('" + id + "', '" + custId + "','"
				+ empId + "','" + status.toString()+ "','" + dateOfRental + "','" + dateOfReturn + "')";
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

	// select 
	public static Order read(String id) {
		String selectSql = "SELECT * FROM grizzlydb.order WHERE id ='" + id + "'";
		Order order = null;
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			result.next();
			String customerId = result.getString("custId");
			String employeeId = result.getString("empId");
			Status status = models.Status.valueOf(result.getString("Status"));
			Date dateOfRental = result.getDate("dateOfRental");
			Date dateOfReturn = result.getDate("dateOfReturn");

			order = new Order(id, customerId, employeeId, status, dateOfRental, dateOfReturn);
			
			System.out.println("ID: " + id + "\n\tCustomer ID: " + customerId + "\n\tEmployee ID: " + employeeId
					+ "\n\tDate of Rental:" + dateOfRental + "\n\tDate of Rental:" + dateOfReturn);
			
			logger.info("Order Records Accessed");
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
			logger.error("Unable To Access Order Records, "+e.getMessage());
		}
		return order;
	}
	
	// select all
	public static ArrayList<Order> readAll() {
		String selectSql = "SELECT * FROM grizzlydb.order WHERE id = 1";
		ArrayList<Order> orders = new ArrayList<>();
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("id");
				String customerId = result.getString("custId");
				String employeeId = result.getString("empId");
				Status status = models.Status.valueOf(result.getString("Status"));
				Date dateOfRental = result.getDate("dateOfRental");
				Date dateOfReturn = result.getDate("dateOfReturn");

				orders.add(new Order(id, customerId, employeeId, status, dateOfRental, dateOfReturn));
				System.out.println("ID: " + id + "\n\tCustomer ID: " + customerId + "\n\tEmployee ID: " + employeeId
						+ "\n\tDate of Rental:" + dateOfRental + "\n\tDate of Rental:" + dateOfReturn);
			}
			logger.info("Order Records Accessed");
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
			logger.error("Unable To Access Order Records, "+e.getMessage());
		}
		return orders;
	}

	// update 
	//TODO complete updateAll
	public static void update(String id, String employeeId, Status status, Date dateOfReturn) {
		String updateSQL = "UPDATE grizzlydb.order SET id='" + id + "',empId = '"+employeeId+"', WHERE id = '" + id+"'";
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
	public static void delete(String id) {
		String deleteSQL = "DELETE FROM grizzlydb.order WHERE id = " + id;
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
