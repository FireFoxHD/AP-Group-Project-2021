package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dbconnection.DbConnect;

public class PasswordController {
	
	private static Statement stmt;
	private static ResultSet result;
	private static int numOfRowsAffected;
	private static Connection connection;
	private static final Logger logger = LogManager.getLogger(String.class);
	
	public PasswordController() {
		PasswordController.stmt = null;
		PasswordController.result = null;
		PasswordController.numOfRowsAffected = 0;
		PasswordController.connection = DbConnect.getConnection();
	}
	
	
	// Create Password
	public static void createPassword(String id, String password) {
		String insertSql = "INSERT INTO grizzlydb.hash VALUES ('" + id + "', '" + password+"')";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(insertSql);
			if (numOfRowsAffected == 1) {
				JOptionPane.showMessageDialog(null, "Password entry created", "Password Creation",
						JOptionPane.INFORMATION_MESSAGE);
				logger.info("Password Updated For Employee " +id);
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception thrown: create " + e.getMessage());
			logger.error("Unable To Update Password For Employee " +id+"\n"+e.getMessage());
		}
	
	}
	
	//TODO update password 
	
	//TODO delete password
	
	//TODO read hash
}
