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
import models.Employee;
import models.Role;

public class EmployeeController {
	
	private static Statement stmt;
	private static ResultSet result;
	private static int numOfRowsAffected;
	private static Connection connection;
	private static final Logger logger = LogManager.getLogger(Employee.class);
	
	
	public EmployeeController() {
		EmployeeController.stmt = null;
		EmployeeController.result = null;
		EmployeeController.numOfRowsAffected = 0;
		EmployeeController.connection = DbConnect.getConnection();
	}
	
	// create
	public static Boolean create(String id, String firstname, String lastname, String email, String phoneNumber, Role role, String pass) {
		String insertSql = "INSERT INTO grizzlydb.employee VALUES ('"+id+"','"+firstname+"','"+lastname+"','"+ email + "','"+ phoneNumber +"','"+role.toString()+"')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Employee record created", "Employee Creation",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Employee Record Created");
			}
			
			new PasswordController();
			PasswordController.createPassword(id, pass);
			
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
			logger.error("Could Not Create Employee Record: "+e.getMessage());
		}
		
		if (numOfRowsAffected == 1) {
			return true;
		}else {
			return false;
		}

	}

	//Read
	public static Employee read(String id) {
		String selectSql = "SELECT * FROM grizzlydb.employee WHERE id =" + id;
		Employee emp = null;
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("email");
				String phoneNumber = result.getString("phoneNumber");
				String role = result.getString("role");
				
				emp = new Employee(id, firstname,lastname, email, phoneNumber, Role.valueOf(role));
				System.out.println("ID: " + id +"\tName: " + firstname+" "+lastname+"\tRole: "+Role.valueOf(role));
				logger.info("Employee Record Accessed For " +id);
			}
		} catch (SQLException e) {
			System.err.println("Error Selecting: " + e.getMessage());
			logger.error("Unable To Read Employee Record For "+id+ "\n" +e.getMessage());
		}
		
		return emp;
	}
	
	// select all
	public static ArrayList<Employee> readAll() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String selectSql = "SELECT * FROM grizzlydb.employee WHERE 1 = 1";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("id");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String email = result.getString("email");
				String phoneNumber = result.getString("phoneNumber");
				String role = result.getString("role");
				
				employees.add(new Employee(id, firstname,lastname, email, phoneNumber,Role.valueOf(role)));
		
				System.out.println("ID: " + id + "\tName: " + firstname+" "+lastname+"\tRole: "+role);
			}
			logger.info("Employee Records Accessed");
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
			logger.error("Could Not Access Employee Records, "+e.getMessage());
		}
		return employees;
	}
	
	// update
	public static Boolean update(String id, String firstname, String lastname, String email, String phoneNumber, Role role) {
		String updateSQL = "UPDATE grizzlydb.employee SET id ='" + id + "', firstname ='"+firstname+"', lastname ='"+lastname+"', email ='"+email+"', phoneNumber ='"+phoneNumber+"', role ='"+role.toString()+"' WHERE id = " + id;
		
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
		
		if (numOfRowsAffected == 1) {
			return true;
		}else {
			return false;
		}

	}
	

	// Delete
	public static Boolean delete(String id) {
		String deleteSQL = "DELETE FROM grizzlydb.employee WHERE id = " + id;
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
		
		if (numOfRowsAffected == 1) {
			return true;
		}else {
			return false;
		}
		

	}

}
