package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import dbconnection.DbConnect;

public class Item {
	private String id;
	private String name;
	private double cost;
	private String category;
	private int numInStock;
	private Connection connection = DbConnect.getConnection();
	
	public Item() {
		this.id = "";
		this.name = "";
		this.cost = 0.0;
		this.category = "";
		this.numInStock = 0;
	}
	
	public Item(String id, String name, double cost, String category, int numInStock) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.category = category;
		this.numInStock = numInStock;
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

	public int getNumInStock() {
		return numInStock;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	@Override
	public String toString() {
		return "Equipment [equip_id=" + id + ", name=" + name + ", category=" + category + ", cost=" + cost
				+ ", status=" + numInStock + "]";
	}


	public void create(String id,  String name, double cost, String category, int numInStock) {
		String insertSql = "INSERT INTO equipment_rental.equipment_table (equipment_id, equipment_category, equipment_name, cost, rental_status) VALUES ('"
				+ id + "','" + category + "','" + name + "', '" + cost + "', '" + numInStock + "')";
		try {
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

	public void read(String id) {
		String selectSql = "SELECT * FROM equipment_rental.equipment_table WHERE equipment_id = '" + id + "'";
		try {
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
	
	public void readAll() {
		String selectSql = "SELECT * FROM equipment_rental.equipment_table WHERE 1=1";
		try {
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

	public void updateAll(String id,  String name, double cost, String category, int numInStock) {
		String updateSql = "UPDATE equipment_rental.equipment_table SET equipment_category = '" + category
				+ "', equipment_name='" + name + "', cost = '" + cost + "', rental_status = '" + numInStock
				+ "' WHERE equipment_id = '" + id + "'";
		try {
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

	public void updateName(String id,  String name) {
		String updateSql = "UPDATE equipment_rental.equipment_table SET equipment_name='" + name + "' WHERE equipment_id = '" + id + "'";
		try {
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
	
	public void updateCost(String id,  double cost) {
		String updateSql = "UPDATE equipment_rental.equipment_table SET cost='" + cost + "' WHERE equipment_id = '" + id + "'";
		try {
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

	public void updateStock(String id,  int numInStock) {
		String updateSql = "UPDATE equipment_rental.equipment_table SET quantityInStock='" + numInStock + "' WHERE equipment_id = '" + id + "'";
		try {
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

	public void updateCategory(String id,  String category) {
		String updateSql = "UPDATE equipment_rental.equipment_table SET category='" + category + "' WHERE equipment_id = '" + id + "'";
		try {
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

	public void Delete(String id) {
		String deleteSql = "DELETE FROM equipment_rental.equipment_table WHERE equipment_id = " + id;
		try {
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

	
}
