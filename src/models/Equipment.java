package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


import dbconnection.DbConnect;

public class Equipment {
	private String id;
	private String name;
	private String category;
	private double cost;
	private String status;
	
	
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Equipment [equip_id=" + id + ", name=" + name + ", category=" + category + ", cost=" + cost
				+ ", status=" + status + "]";
	}


	public void create(String id, String category, String name, double cost, String status) {
		String insertSql = "INSERT INTO equipment_rental.equipment_table (equipment_id, equipment_category, equipment_name, cost, rental_status) VALUES ('"
				+ id + "','" + category + "','" + name + "', '" + cost + "', '" + status + "')";
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			int numRowsAffected = stat.executeUpdate(insertSql);

			if(numRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Equipment Record Created", "Message", JOptionPane.INFORMATION_MESSAGE);
				
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			
		}
	}

	public void Delete(String id) {
		String deleteSql = "DELETE FROM equipment_rental.equipment_table WHERE equipment_id = " + id;
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			int numRowsAffected = stat.executeUpdate(deleteSql);

			if(numRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Equipment Record Deleted", "Message", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
			
		}
	}

	public void readAll() {
		String selectSql = "SELECT * FROM equipment_rental.equipment_table WHERE 1=1";
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			ResultSet result = null;
			result = stat.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("equipment_id");
				String category = result.getString("equipment_category");
				String name = result.getString("equipment_name");
				double cost = result.getDouble("cost");
				String status = result.getString("rental_status");
				System.out.println("ID: " + id + "\t\tName: " + name + "\t\tCategory: " + category + "\t\tCost: " + cost
						+ "\t\tStatus: " + status);
			}

			
		}
		catch(SQLException e)
		{
			System.err.println("SQL Exception: " +e.getMessage());
			

		}
	}

	public void update(String id, String category, String name, double cost, String status) {
		String updateSql = "UPDATE equipment_rental.equipment_table SET equipment_category = '" + category
				+ "', equipment_name='" + name + "', cost = '" + cost + "', rental_status = '" + status
				+ "' WHERE equipment_id = '" + id + "'";
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			int numRowsAffected = stat.executeUpdate(updateSql);

			if(numRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Updated Successfully", "Update Message", JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		catch(SQLException e)
		{
			System.err.println("Update error: " +e.getMessage());
			
		}
	}

	public void read(String id) {
		String selectSql = "SELECT * FROM equipment_rental.equipment_table WHERE equipment_id = '" + id + "'";
		try {
			Connection connection = DbConnect.getConnection();
			Statement stat = connection.createStatement();
			ResultSet result = null;
			result = stat.executeQuery(selectSql);
			result.next();
			id = result.getString("equipment_id");
			String category = result.getString("equipment_category");
			String name = result.getString("equipment_name");
			double cost = result.getDouble("cost");
			String status = result.getString("rental_status");

			System.out.println("ID: "+id+"\t\tName: "+name+"\t\tCategory: "+category+"\t\tCost: "+cost+"\t\tStatus: "+status);
			
			
		}
		catch(SQLException e)
		{
			System.err.println("SQL Exception: " +e.getMessage());
			
		}
	}
}
