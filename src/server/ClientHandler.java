package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{

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

	@Override
	public void run() {
		try {
			while(true){
				String action = (String) objIs.readObject();
				System.out.println("Action: "+ action);
				
				if(action.equalsIgnoreCase("test")) {
					objOs.writeObject("test action recieved");
				}else {
					objOs.writeObject("Not test");
				}
			}
		}catch(IOException | ClassNotFoundException e) {
			System.err.println("Issue running in Client handler");
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		
	}
	
	private void closeConnection(){
		try{
			objOs.close();
			objIs.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
