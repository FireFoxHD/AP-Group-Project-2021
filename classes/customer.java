package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class customer {
	private int id;
	private  String name;
	private  String password;
	private  String order;
	private float balance;
	private Statement stmt = null;
	private ResultSet result = null;
	private int numOfRowsAffected = 0;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
	
	public String getOrder() {
		return order;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	//CRUD Operations
	
	//create
	public void create(Connection connection) {
		String insertSql = "INSERT INTO equipment_rental.customer VALUES ('"+getId()+"', '"+getName()+"','"+getPassword()+"','"+getOrder()+"','"+getBalance()+"')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer created", "Customer Creation", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
		}
		
	}
	
	
	//select all
	public void readAll(Connection connection) {
		String selectSql = "SELECT * FROM equipment_rental.customer WHERE 1 = 1";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while(result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				String order = result.getString("order");
				String balance = result.getString("balance");
				
				System.out.println("ID: " + id + "\tName: " + name + "\tOrder: " + order + "\tBalance:" +balance);
			}
		}catch(SQLException e) {
			System.err.println("Error Selecting All: " + e.getMessage());
		}
		
	}
	
	//update
	public void update(String id, String name, String password, String order, float balance, Connection connection) {
		String updateSQL = "UPDATE equipment_rental.customer SET id='" + getId() + "' WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer record has been updated", "Customer Update", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch (SQLException e) {
			System.err.println("Error Updating: " + e.getMessage());
		}
		
	}
	
	//delete
	public void delete(String id, Connection connection) {
		String deleteSQL = "DELETE FROM equipment_rental.customer WHERE id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSQL);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Customer record deleted", "Customer Delete", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(SQLException e) {
			System.err.println("Error Deleting: " + e.getMessage());
		}
	}
}