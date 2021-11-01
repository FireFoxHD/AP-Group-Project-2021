package classes;

import java.sql.*;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class employee {
	private String id;
	private String name;
	private String password;
	private Statement stmt = null;
	private ResultSet result = null;
	private int numOfRowsAffected = 0;
	
	private static final Logger logger = LogManager.getLogger(employee.class);
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//CRUD operations
	
	//create
	public void create(Connection connection) {
		String insertSql = "INSERT INTO equipment_rental.employee VALUES ('"+getId()+"', '"+getName()+"','"+getPassword()+"')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Employee record created", "Employee Creation", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Employee record created");
			}
		}catch(SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
			logger.error("Employee record not created: " +e.getMessage());
		}
		
	}
	
	//select all
	public void readAll(Connection connection) {
		String selectSql = "SELECT * FROM equipment_rental.employee WHERE 1 = 1";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while(result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				
				System.out.println("ID: " + id + "\tName: " + name);
			}
			logger.info("Employee records read");
		}catch(SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
			logger.error("Unable to read employee records: "+e.getErrorCode());
		}
		
	}
	
	//update
		public void update(String id, String name, String password, Connection connection) {
			String updateSQL = "UPDATE equipment_rental.employee SET id='" + getId() + "' WHERE id = " + id;
			try {
				stmt = connection.createStatement();
				numOfRowsAffected = stmt.executeUpdate(updateSQL);
				if (numOfRowsAffected == 1) {
					JOptionPane.showMessageDialog(null, "Employee record has been updated", "Employee Update", JOptionPane.INFORMATION_MESSAGE);
					logger.info("Employee record updated");
				}
			}catch (SQLException e) {
				System.err.println("Error Updating: " + e.getMessage());
				logger.error("Error updating employee record: " +e.getMessage());
			}
			
		}
		
		//delete
		public void delete(String id, Connection connection) {
			String deleteSQL = "DELETE FROM equipment_rental.employee WHERE id = " + id;
			try {
				stmt = connection.createStatement();
				numOfRowsAffected = stmt.executeUpdate(deleteSQL);
				if (numOfRowsAffected == 1) {
					JOptionPane.showMessageDialog(null, "Employee record deleted", "Employee Delete", JOptionPane.INFORMATION_MESSAGE);
					logger.info("Employee record deleted");
				}
			}catch(SQLException e) {
				System.err.println("Error Deleting: " + e.getMessage());
				logger.error("Unable to delete employee record: " +e.getMessage());
			}
		}
	
}
