package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;
import models.Item;

public class InvoiceController {
	//associates items with their respective orders
	
	private static Statement stmt;
	private static ResultSet result;
	private static int numOfRowsAffected;
	private static Connection connection;
	private static final Logger logger = LogManager.getLogger(Item.class);
	
	public InvoiceController(){
		InvoiceController.stmt = null;
		InvoiceController.result = null;
		InvoiceController.numOfRowsAffected = 0;
		InvoiceController.connection = DbConnect.getConnection();
	}
	
	public static Boolean create(String orderid,  String itemid, int quantity) {
		String insertSql = "INSERT INTO grizzlydb.order_item (orderID, itemID, quantity) VALUES ('"+ orderid + "','" + itemid + "','" + quantity +"')";
		try {
			stmt = connection.createStatement();
			int numRowsAffected = stmt.executeUpdate(insertSql);

			if(numRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Equipment Record Created", "Message", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Item ["+itemid+"] Added to Order["+orderid+"] Created");
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			logger.error("Could Not add Item ["+itemid+"] to Order["+orderid+"] \n"+e.getMessage());
		}
		
		if (numOfRowsAffected == 1) {
			return true;
		}else {
			return false;
		}
	}

	
	public static ArrayList<Item> read(String orderid) {
		ArrayList<Item> items = new ArrayList<Item>();
		String selectSql = "SELECT * FROM grizzlydb.order_item WHERE orderID ='" + orderid + "'";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			new ItemController();
			while (result.next()) {
				String itemid = result.getString("itemID");
				items.add(ItemController.read(itemid));
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

	public static Boolean update(String orderid, String itemId, String newItem, int quantity) {
		if(deleteItemFromOrder(orderid, itemId) && create(orderid, newItem, quantity)){
			return true;
		}
		return false;
	}


	public static Boolean deleteItemFromOrder(String orderid, String itemid) {
		String deleteSql = "DELETE FROM grizzlydb.order_item WHERE orderID = '" + orderid +"' AND itemID = "+itemid;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSql);

			if(numOfRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Equipment Record Deleted", "Message", 
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Item ["+itemid+"] was Deleted from order ["+orderid+"] Deleted");
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
			logger.error("Unable To Delete Item ["+itemid+"] from order ["+orderid+"]"+ e.getMessage());
		}
		
		if (numOfRowsAffected == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Boolean deleteOrder(String orderid) {
		String deleteSql = "DELETE FROM grizzlydb.order_item WHERE orderID = " + orderid;
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(deleteSql);

			if(numOfRowsAffected > 0)
			{
				JOptionPane.showMessageDialog(null, "Equipment Record Deleted", "Message", 
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Items From order ["+orderid+"] Deleted");
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
			logger.error("Unable To Delete Items From order ["+orderid+"], "+e.getMessage());
		}
		
		if (numOfRowsAffected > 1) {
			return true;
		}else {
			return false;
		}
	}
	
}
