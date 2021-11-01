package dbconnection;

import java.sql.Connection;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import testing.TestingDriver;

import java.sql.*;

public class DbConnect {
		private static Connection connection = null;
		private static final Logger logger = LogManager.getLogger(DbConnect.class);
		public static Connection getConnection() {
			if (connection == null) {
				String url = "jdbc:mysql://localhost:3306/equipment_rental";
				try {
					connection = DriverManager.getConnection(url, "root", "");
					if (connection != null) {
						System.out.println("Connection Successful");
						JOptionPane.showMessageDialog(null, "Connected to Local Server and Database","JDBC Connection Status", JOptionPane.INFORMATION_MESSAGE);
						logger.info("Connected To Datbase");
					}
				}catch (Exception e) {
					System.err.println("Exception: " + e.getMessage());
					logger.error("Error: " +e.getMessage());	
				}
			}
			return connection;
		}

	}