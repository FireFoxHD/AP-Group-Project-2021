package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread{

	private Socket client;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	
	public ClientHandler(Socket clientSocket){
		this.client = clientSocket;
		configureStreams();
	}
	
	private void configureStreams(){
		try{
			this.objOs = new ObjectOutputStream(client.getOutputStream());
			this.objIs = new ObjectInputStream(client.getInputStream());
		}catch (IOException e){
			System.err.println("Error configuring streams in client handler");
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			while(true){
				String action = (String) objIs.readUTF();
				System.out.println("Action: "+ action);
				
				if(action.equalsIgnoreCase("test")) {
					objOs.writeUTF("test action recieved");
				}else {
					objOs.writeUTF("Not test");
				}
				
				objOs.flush();
				
			}
		}catch(IOException e) {
			System.err.println("Issue running in Client handler");
			e.printStackTrace();
		}
		
		this.closeConnection();
	}
	
	private void closeConnection(){
		try{
			if(objOs != null) {
				objOs.close();
			}
			
			if(objIs != null) {
				objIs.close();
				client.close();
			}
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
