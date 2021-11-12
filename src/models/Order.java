package models;

import java.sql.*;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;

public class Order {
	private String id;
	private String customerId;
	private String employeeId;
	private Status status;
	private Date dateOfRental;
	private Date dateOfReturn;
	
	private Statement stmt = null;
	private ResultSet result = null;
	private int numOfRowsAffected = 0;
	private Connection connection = DbConnect.getConnection();
	private static final Logger logger = LogManager.getLogger(Order.class);
	
	public Order() {
		this.id = "";
		this.customerId = "";
		this.employeeId = "";
		this.setStatus(null);
		this.dateOfRental = null;
		this.dateOfReturn = null;
	}
	
	
	public Order(String id, String customerId, String employeeId, Status status, Date dateOfReturn) {
		this.id = id;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.setStatus(Status.PENDING);
		this.dateOfRental = new Date(System.currentTimeMillis());
		this.dateOfReturn = dateOfReturn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDateOfRental() {
		return dateOfRental;
	}

	public void setDateOfRental(Date dateOfRental) {
		this.dateOfRental = dateOfRental;
	}

	public Date getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	// CRUD Operations

	// create
	public void create() {
		String insertSql = "INSERT INTO equipment_rental.order VALUES ('" + getId() + "', '" + getCustomerId() + "','"
				+ getEmployeeId() + "','" + getDateOfRental() + "','" + getDateOfReturn() + "')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Order created", "Order Creation", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Order Record "+getId()+" Created");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
			logger.error("Unable To Create Order Record "+getId()+", "+e.getMessage());
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
				String customerId = result.getString("customer ID");
				String employeeId = result.getString("employee ID");
				Date dateOfRental = result.getDate("dateOfRental");
				Date dateOfReturn = result.getDate("date of return");


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
	public void update(String id, String customerId, String employeeId, String dateOfRental, String dateOfReturn,
			String equipmentId) {
		String updateSQL = "UPDATE equipment_rental.order SET id='" + getId() + "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Order has been updated", "Order Update",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Order Record "+getId()+" Updated");
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
			logger.error("Unable To Update Order Record "+getId()+", "+e.getMessage());
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
				logger.info("Order Record "+getId()+" Deleted");
			}
		} catch (SQLException e) {
			System.err.println("Error Deleting: " + e.getMessage());
			logger.error("Unable To Delete Order Record "+getId()+", "+e.getMessage());
		}
	}


	
}
