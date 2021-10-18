package dbconnection;

import java.sql.Connection;

import javax.swing.JOptionPane;

import java.sql.*;

public class DbConnect {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			String url = "jdbc:mysql://localhost:3306/equipment_rental";
			try {
				connection = DriverManager.getConnection(url, "root", "");
				if (connection != null) {
					System.out.println("Connection Successful");
					JOptionPane.showMessageDialog(null, "Connected to Local Server and Database",
							"JDBC Connection Status", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}

		}

		return connection;
	}

}