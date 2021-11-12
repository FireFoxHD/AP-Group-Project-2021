package models;

import java.sql.*;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;

public class Employee {
	private String id;
	private String firstname;
	private String lastname;
	private String password;
	private String role;
	
	private Statement stmt = null;
	private ResultSet result = null;
	private int numOfRowsAffected = 0;
	private Connection connection = DbConnect.getConnection();
	private static final Logger logger = LogManager.getLogger(Employee.class);
	
	public Employee() {
		this.id = "";
		this.firstname = "";
		this.lastname = "";
		this.password = "";
		this.role = "";
	}
	
	public Employee(String id, String firstname, String lastname, String pass, String role) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = pass;
		this.role = role;
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
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tName: " + this.firstname +" "+this.lastname + "\t pass: "+ this.password + "\t Role: "+this.role;
		
	}
	

	// CRUD operations

	// create
	public void create() {
		String insertSql = "INSERT INTO equipment_rental.employee VALUES ('"+id+"','"+firstname+"','"+lastname+"','"+role+"')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Employee record created", "Employee Creation",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Employee Record Created");
			}
			
			createPassword(getId(), getPassword());
			
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
			logger.error("Could Not Create Employee Record: "+e.getMessage());
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
				logger.info("Password Updated For Employee " +getId());
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
			logger.error("Unable To Update Password For Employee " +getId()+"\n"+e.getMessage());
		}

	}
	
	//Read
	public void read() {
		String selectSql = "SELECT * FROM equipment_rental.employee WHERE id =" + id;
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("id");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String role = result.getString("role");

				System.out.println("ID: " + id +"\tName: " + firstname+" "+lastname+"\tRole: "+role);
				logger.info("Employee Record Accessed For " +getId());
			}
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
			logger.error("Unable To Read Employee Record For "+getId()+ "\n" +e.getMessage());
		}

	}
	
	// select all
	public void readAll() {
		String selectSql = "SELECT * FROM equipment_rental.employee WHERE 1 = 1";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("id");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String password = result.getString("password");
				String role = result.getString("role");

				System.out.println("ID: " + id + "\tPass: "+ password +"\tName: " + firstname+" "+lastname+"\tRole: "+role);
			}
			logger.info("Employee Records Accessed");
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
			logger.error("Could Not Access Employee Records, "+e.getMessage());
		}

	}
	
	// update
	public void updateAll(String id, String firstname, String lastname, String password, String role) {
		String updateSQL = "UPDATE equipment_rental.employee SET id='" + getId() + "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Employee record has been updated", "Employee Update",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Employee Record "+getId()+ "Updated");
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
			logger.error("Could Not Update Employee Record "+getId()+"\n"+e.getMessage());
		}

	}
	
	// update Role
	public void updateRole(String role) {
		String updateSQL = "UPDATE equipment_rental.employee SET role ='" + role + "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Employee record has been updated", "Employee Update",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Role Updated For Employee "+getId());
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
			logger.error("Could Not Update Role For Employee Record "+getId()+"\n"+e.getMessage());
		}

	}

	// Delete
	public void delete(String id) {
		String deleteSQL = "DELETE FROM equipment_rental.employee WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Employee record deleted", "Employee Delete",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Employee Record"+getId()+"Deleted");
			}
		} catch (SQLException e) {
			System.err.println("Error Deleting: " + e.getMessage());
			logger.error("Could Not Delete Employee Record "+getId()+"\n"+e.getMessage());
		}
	}

}
