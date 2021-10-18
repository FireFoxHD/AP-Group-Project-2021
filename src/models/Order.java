package models;

import java.sql.*;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Order {
	private String id;
	private String customerId;
	private String employeeId;
	private Date dateOfRental;
	private Date dateOfReturn;
	private String equipmentId;
	private Statement stmt = null;
	private ResultSet result = null;
	private int numOfRowsAffected = 0;
	
	public Order() {
		this.id = "";
		this.customerId = "";
		this.employeeId = "";
		this.equipmentId = "";
		this.dateOfRental = new Date(System.currentTimeMillis());
		this.dateOfReturn = new Date(System.currentTimeMillis());
	}
	
	
	public Order(String Orderid, String customerId, String employeeId, String equipmentId, Date dateOfRental, Date dateOfReturn) {
		this.id = Orderid;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.equipmentId = equipmentId;
		this.dateOfRental = dateOfRental;
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

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	// CRUD Operations

	// create
	public void create(Connection connection) {
		String insertSql = "INSERT INTO equipment_rental.order VALUES ('" + getId() + "', '" + getCustomerId() + "','"
				+ getEmployeeId() + "','" + getDateOfRental() + "','" + getDateOfReturn() + "','" + getEquipmentId()
				+ "')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Order created", "Order Creation", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
		}

	}

	// select all
	public void readAll(Connection connection) {
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
				String equipmentId = result.getString("equipment ID");

				System.out.println("ID: " + id + "\n\tCustomer ID: " + customerId + "\n\tEmployee ID: " + employeeId
						+ "\n\tDate of Rental:" + dateOfRental + "\n\tDate of Rental:" + dateOfReturn
						+ "\n\tEmployee ID:" + equipmentId);
			}
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
		}

	}

	// update
	public void update(String id, String customerId, String employeeId, String dateOfRental, String dateOfReturn,
			String equipmentId, Connection connection) {
		String updateSQL = "UPDATE equipment_rental.order SET id='" + getId() + "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Order has been updated", "Order Update",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
		}

	}

	// delete
	public void delete(String id, Connection connection) {
		String deleteSQL = "DELETE FROM equipment_rental.order WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Order deleted", "Order Delete", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error Deleting: " + e.getMessage());
		}
	}
}
