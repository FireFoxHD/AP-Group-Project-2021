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
import models.Item;

public class ItemController {
	private Statement stmt;
	private ResultSet result;
	private int numOfRowsAffected;
	private Connection connection;
	private static final Logger logger = LogManager.getLogger(Item.class);
	
	public ItemController(){
		this.stmt = null;
		this.result = null;
		this.numOfRowsAffected = 0;
		this.connection = DbConnect.getConnection();
	}
	
	public void create(String id,  String name, double cost, String category, int numInStock) {
		String insertSql = "INSERT INTO equipment_rental.equipment_table (equipment_id, equipment_category, equipment_name, cost, rental_status) VALUES ('"
				+ id + "','" + category + "','" + name + "', '" + cost + "', '" + numInStock + "')";
		try {
			stmt = connection.createStatement();
			int numRowsAffected = stmt.executeUpdate(insertSql);

			if(numRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Equipment Record Created", "Message", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Item Record "+id+  " Created");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			logger.error("Could Not Create Item Record "+id+ ", "+e.getMessage());
		}
	}

	public Item read(String id) {
		Item item = null;
		String selectSql = "SELECT * FROM grizzlydb.item WHERE equipment_id = '" + id + "'";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			result.next();
			String category = result.getString("category");
			String name = result.getString("name");
			double cost = result.getDouble("cost");
			int numInStock = result.getInt("quantityInStock");
			
            item = new Item(id,name,cost,category,numInStock);
			System.out.println("ID: " + id + "\t\tName: " + name + "\t\tCategory: " + category + "\t\tCost: " + cost
					+ "\t\numInStock: " + numInStock);
			
			logger.info("Item Record "+id+" Accessed");
			
		}
		catch(SQLException e)
		{
			System.err.println("SQL Exception: " +e.getMessage());
			logger.error("Could Not Access Item Record," +id+"\n"+e.getMessage());
		}
		return item;
	}
	
	public ArrayList<Item> readAll() {
		ArrayList<Item> items = new ArrayList<Item>();
		String selectSql = "SELECT * FROM grizzlydb.item WHERE 1=1";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			while (result.next()) {
				String id = result.getString("id");
				String category = result.getString("category");
				String name = result.getString("name");
				double cost = result.getDouble("cost");
				int numInStock = result.getInt("quantityInStock");
				items.add(new Item(id,name,cost,category,numInStock));
				
				System.out.println("ID: " + id + "\t\tName: " + name + "\t\tCategory: " + category + "\t\tCost: " + cost
						+ "\t\numInStock: " + numInStock);
			}
			logger.info("Item Records Accessed");
		}
		catch(SQLException e)
		{
			System.err.println("SQL Exception: " +e.getMessage());
			logger.error("Could Not Access Item Records, "+e.getMessage());
		}
		return items;
	}

	public void update(String id,  String name, double cost, String category, int numInStock) {
		String updateSql = "UPDATE grizzlydb.item SET category = '" + category+ "',"
				+ " name='" + name + "', cost = '" + cost + "', quantityInStock = '" + numInStock
				+ "' WHERE id = '" + id + "'";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSql);

			if(numOfRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Updated Successfully", "Update Message", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Item Record"+id+" Updated");
			}
		}
		catch(SQLException e)
		{
			System.err.println("Update error: " +e.getMessage());
			logger.error("Error Updating Item Record "+id+", "+e.getMessage());
		}
	}

	public void updateCategory(String id,  String category) {
		String updateSql = "UPDATE grizzlydb.item SET category='" + category + "' WHERE equipment_id = '" + id + "'";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSql);

			if(numOfRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Updated Successfully", "Update Message", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Category Updated For Item Record "+id);
			}
		}
		catch(SQLException e)
		{
			System.err.println("Update error: " +e.getMessage());
			logger.error("Unable Top Update Category For Item Record "+id+", "+e.getMessage());
		}
	}

	public void Delete(String id) {
		String deleteSql = "DELETE FROM equipment_rental.equipment_table WHERE equipment_id = " + id;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSql);

			if(numOfRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Equipment Record Deleted", "Message", 
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Item Record "+id+" Deleted");
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
			logger.error("Unable To Delete Item Record "+id+", "+e.getMessage());
		}
	}
	
}
