package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;
import models.Employee;

public class EmployeeController {
	
	private Statement stmt;
	private ResultSet result;
	private int numOfRowsAffected;
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(Employee.class);
	
	
		public EmployeeController() {
			this.stmt = null;
			this.result = null;
			this.numOfRowsAffected = 0;
			this.connection = DbConnect.getConnection();
		}
		
		// create
		public void create(String id, String firstname, String lastname, String pass, String role) {
			String insertSql = "INSERT INTO equipment_rental.employee VALUES ('"+id+"','"+firstname+"','"+lastname+"','"+role+"')";
			try {
				stmt = connection.createStatement();
				numOfRowsAffected = stmt.executeUpdate(insertSql);
				if (numOfRowsAffected == 1) {
					JOptionPane.showMessageDialog(null, "Employee record created", "Employee Creation",
							JOptionPane.INFORMATION_MESSAGE);
					logger.info("Employee Record Created");
				}
				
				PasswordController.createPassword(id, pass);
				
			} catch (SQLException e) {
				System.out.println("SQL Exception thrown: create " + e.getMessage());
				logger.error("Could Not Create Employee Record: "+e.getMessage());
			}

		}

		
		//Read
		public Employee read(String id) {
			String selectSql = "SELECT * FROM equipment_rental.employee WHERE id =" + id;
			Employee emp = null;
			try {
				stmt = connection.createStatement();
				result = stmt.executeQuery(selectSql);
				while (result.next()) {
					String Dbid = result.getString("id");
					String firstname = result.getString("firstname");
					String lastname = result.getString("lastname");
					String role = result.getString("role");
					emp = new Employee(Dbid, firstname,lastname,"",role);
					System.out.println("ID: " + id +"\tName: " + firstname+" "+lastname+"\tRole: "+role);
					logger.info("Employee Record Accessed For " +id);
				}
			} catch (SQLException e) {
				System.err.println("Error Selecting All: " + e.getMessage());
				logger.error("Unable To Read Employee Record For "+id+ "\n" +e.getMessage());
			}
			
			return emp;
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
		public void updateAll(String id, String firstname, String lastname, String role) {
			String updateSQL = "UPDATE equipment_rental.employee SET id ='" + id + "', firstname WHERE id = " + id;
			try {
				stmt = connection.createStatement();
				numOfRowsAffected = stmt.executeUpdate(updateSQL);
				if (numOfRowsAffected == 1) {
					JOptionPane.showMessageDialog(null, "Employee record has been updated", "Employee Update",
							JOptionPane.INFORMATION_MESSAGE);
					logger.info("Employee Record "+ id + "Updated");
				}
			} catch (SQLException e) {
				System.err.println("Error Updating: " + e.getMessage());
				logger.error("Could Not Update Employee Record "+ id +"\n"+e.getMessage());
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
					logger.info("Employee Record"+ id +"Deleted");
				}
			} catch (SQLException e) {
				System.err.println("Error Deleting: " + e.getMessage());
				logger.error("Could Not Delete Employee Record "+ id +"\n"+e.getMessage());
			}
		}

}
