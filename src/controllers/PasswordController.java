package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
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
		password = encryptPassword(password);
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
	
	// Read Password
	public static String readHash(String id) {
		String selectSql = "SELECT * FROM grizzlydb.hash WHERE id = '" + id + "'";
		String password = "";
		try {
			stmt = connection.createStatement();
			result = stmt.executeQuery(selectSql);
			result.next();
			password = result.getString("hash");
			logger.info("Password Retrived "+id+" Accessed");
			
		}
		catch(SQLException e)
		{
			System.err.println("SQL Exception: " +e.getMessage());
			logger.error("Could Not Access Item Record," +id+"\n"+e.getMessage());
		}
		return password;
	}
	
	// Update Password
	public static void update(String id,  String password) {
		password = encryptPassword(password);
		String updateSql = "UPDATE grizzlydb.hash SET hash='" + password + "' WHERE id = '" + id + "'";
		try {
			stmt = connection.createStatement();
			numOfRowsAffected = stmt.executeUpdate(updateSql);

			if(numOfRowsAffected == 1)
			{
				JOptionPane.showMessageDialog(null, "Updated Successfully", "Update Message", JOptionPane.INFORMATION_MESSAGE);
				logger.info("Name For Item Record "+id+ " Updated");
			}
		}
		catch(SQLException e)
		{
			System.err.println("Update error: " +e.getMessage());
			logger.error("Unable To Update Name For Item " +id+", "+e.getMessage());
		}
	}
	
	// Delete Password
	public static void Delete(String id) {
		String deleteSql = "DELETE FROM grizzlydb.hash WHERE id = " + id;
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
	
	// Validate password
	public static Boolean Validate(String id, String pass) {
		String hashFromDb = readHash(id);
		String password = encryptPassword(pass);
		if(hashFromDb.equals(password)) {
			return true;
		}else {
			return false;
		}	
	}
	
	// Encrypt password
	private static String encryptPassword(String passwordToHash) {
			
        	String generatedPassword = null;
            try {
            	String salt = getSalt();
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(salt.getBytes());
                byte[] bytes = md.digest(passwordToHash.getBytes());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                	//convert to HEX
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                generatedPassword = sb.toString();
            }catch (NoSuchAlgorithmException | NoSuchProviderException  e) {
                e.printStackTrace();
            }
            return generatedPassword;
    }

    // Add salt
    private static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException 
    {
        // Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

        // Create array for salt
        byte[] salt = new byte[16];

        // Get a random salt
        sr.nextBytes(salt);

        // return salt
        return salt.toString();
    }
}
