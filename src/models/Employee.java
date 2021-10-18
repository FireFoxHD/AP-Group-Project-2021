package models;

import java.sql.*;

import javax.swing.JOptionPane;

public class Employee {
	private String id;
	private String name;
	private String password;
	private Statement stmt = null;
	private ResultSet result = null;
	private int numOfRowsAffected = 0;
	
	public Employee() {
		this.id = "";
		this.name = "";
		this.password = "";
	}
	
	public Employee(String id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.password = pass;
	}

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
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tName: " + this.name + "\t pass: "+ this.password;
	}
	

	// CRUD operations

	// create
	public void create(Connection connection) {
		String insertSql = "INSERT INTO equipment_rental.employee VALUES ('" + getId() + "', '" + getName() + "','"
				+ getPassword() + "')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Employee record created", "Employee Creation",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
		}

	}

	// select all
	public void readAll(Connection connection) {
		String selectSql = "SELECT * FROM equipment_rental.employee WHERE 1 = 1";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");

				System.out.println("ID: " + id + "\tName: " + name);
			}
		} catch (SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
		}

	}

	// update
	public void update(String id, String name, String password, Connection connection) {
		String updateSQL = "UPDATE equipment_rental.employee SET id='" + getId() + "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Employee record has been updated", "Employee Update",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
		}

	}

	// delete
	public void delete(String id, Connection connection) {
		String deleteSQL = "DELETE FROM equipment_rental.employee WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Employee record deleted", "Employee Delete",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Error Deleting: " + e.getMessage());
		}
	}

}
