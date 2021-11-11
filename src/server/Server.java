package server;


//import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private static ServerSocket serverSocket;
	private static Socket client;
	private static ObjectOutputStream objOs;
	private static ObjectInputStream objIs;
	//private static Connection dBConn = getDatabaseConnection();
	private static ExecutorService pool = Executors.newFixedThreadPool(3);
	
	public Server() {
		//dBConn = getDatabaseConnection();
		createConnection();
		ServerListener();
	}
	
	private static void ServerListener() {
		while (true) {
			System.out.println("[SERVER] Waiting for clients...");
			try {
				client = serverSocket.accept();
				System.out.println("[SERVER] Connected to client...");
			} catch (IOException e) {
				System.out.println("[SERVER] Error connecting to client...");
				e.printStackTrace();
			}
			ClientHandler handler = new ClientHandler(client);
			pool.execute(handler);
		}
	}

	private void createConnection(){
		try{
			serverSocket = new ServerSocket(8888);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void closeConnection(){
		try{
			objOs.close();
			objIs.close();
			client.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

//	private static Connection getDatabaseConnection(){
//		if(dBConn == null){
//			try{
//				String url = "jdbc:mysql://localhost:3306/clientServerLab";
//				dBConn = DriverManager.getConnection(url,"root","");
//				if (dBConn != null) {
//					System.out.println("Connection Successful");
//					JOptionPane.showMessageDialog(null, "Connected to Local Server and Database",
//							"JDBC Connection Status", JOptionPane.INFORMATION_MESSAGE);
//				}
//			}catch (SQLException e){
//				JOptionPane.showMessageDialog(null,"could not connect to database\n"+e,"Connection Failure",JOptionPane.ERROR_MESSAGE);
//			}
//		}
//		return dBConn;
//	}

	
	
}
