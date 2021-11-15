package server;

import java.io.IOException;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import dbconnection.DbConnect;

import javax.swing.JOptionPane;
	
public class Server {
	
	private static ServerSocket server;
	private static Socket client;
	private static int clientCount;
	private static Connection dBConn = null;
	
	private static void start(){
		try{
			dBConn = DbConnect.getConnection();
			server = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientCount=0;
	}
	
	public static void main(String[] args) throws Exception {
		start();
	    try{
	    	System.out.println("[SERVER] Waiting for clients...");
	      	while(true){
			  	client = server.accept();  //server accept the client connection request
			  	clientCount++;
			  	System.out.println("[SERVER] Connected to client ["+clientCount+"]");			
			  	ClientHandler handler = new ClientHandler(client); //send  the request to a separate thread
			    handler.start();
			}
	    }catch(Exception e){
	      System.out.println(e);
	    }
	}
	
}
