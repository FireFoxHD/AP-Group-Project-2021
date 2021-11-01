package classes;

import java.sql.*;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import testing.TestingDriver;

public class order {
	private String id;
	private String customerId;
	private String employeeId;
	private String dateOfRental;
	private String dateOfReturn;
	private String equipmentId;
	private Statement stmt = null;
	private ResultSet result = null;
	private int numOfRowsAffected = 0;
	private static final Logger logger = LogManager.getLogger(order.class);
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
	
	public String getDateOfRental() {
		return dateOfRental;
	}
	
	public void setDateOfRental(String dateOfRental) {
		this.dateOfRental = dateOfRental;
	}
	
	public String getDateOfReturn() {
		return dateOfReturn;
	}
	
	public void setDateOfReturn(String dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}
	
	public String getEquipmentId() {
		return equipmentId;
	}
	
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	//CRUD Operations
	
		//create
		public void create(Connection connection) {
			String insertSql = "INSERT INTO equipment_rental.order VALUES ('"+getId()+"', '"+getCustomerId()+"','"+getEmployeeId()+"','"+getDateOfRental()+"','"+getDateOfReturn()+"','"+getEquipmentId()+"')";
			try {
				stmt = connection.createStatement();
				numOfRowsAffected = stmt.executeUpdate(insertSql);
				if (numOfRowsAffected == 1) {
					JOptionPane.showMessageDialog(null, "Order created", "Order Creation", JOptionPane.INFORMATION_MESSAGE);
					logger.info("Order Created");
				}
			}catch(SQLException e) {
				System.out.println("SQL Exception thrown: create " + e.getMessage());
				logger.error("Order not created, SQL Error: "+ e.getMessage());
			}
			
		}
	
		//select all
		public void readAll(Connection connection) {
			String selectSql = "SELECT * FROM equipment_rental.order WHERE 1 = 1";
			try {
				stmt = connection.createStatement();
				result = stmt.executeQuery(selectSql);
				while(result.next()) {
					String id = result.getString("id");
					String customerId = result.getString("customer ID");
					String employeeId = result.getString("employee ID");
					String dateOfRental = result.getString("date of rental");
					String dateOfReturn = result.getString("date of return");
					String equipmentId = result.getString("equipment ID");
					
					System.out.println("ID: " + id + "\n\tCustomer ID: " + customerId + "\n\tEmployee ID: " 
					+ employeeId + "\n\tDate of Rental:" + dateOfRental + "\n\tDate of Rental:" + dateOfReturn 
					+ "\n\tEmployee ID:" + equipmentId);
				}
				logger.info("Order list Read");
			}catch(SQLException e) {
				System.err.println("Error Selecting All: " + e.getMessage());
				logger.error("Error reading all orders: " +e.getMessage());
			}
			
		}
		
		//update
		public void update(String id, String customerId, String employeeId, String dateOfRental,
				String dateOfReturn, String equipmentId ,Connection connection) {
			String updateSQL = "UPDATE equipment_rental.order SET id='" + getId() + "' WHERE id = " + id;
			try {
				stmt = connection.createStatement();
				numOfRowsAffected = stmt.executeUpdate(updateSQL);
				if (numOfRowsAffected == 1) {
					JOptionPane.showMessageDialog(null, "Order has been updated", "Order Update", JOptionPane.INFORMATION_MESSAGE);
					logger.info("Order updated");
				}
			}catch (SQLException e) {
				System.err.println("Error Updating: " + e.getMessage());
				logger.error("Error updating order: " +e.getMessage());
			}
			
		}
		
		//delete
		public void delete(String id, Connection connection) {
			String deleteSQL = "DELETE FROM equipment_rental.order WHERE id = " + id;
			try {
				stmt = connection.createStatement();
				numOfRowsAffected = stmt.executeUpdate(deleteSQL);
				if (numOfRowsAffected == 1) {
					JOptionPane.showMessageDialog(null, "Order deleted", "Order Delete", JOptionPane.INFORMATION_MESSAGE);
					logger.info("Order deleted");
				}
			}catch(SQLException e) {
				System.err.println("Error Deleting: " + e.getMessage());
				logger.error("Error deleting order: " +e.getMessage());
			}
		}
}
