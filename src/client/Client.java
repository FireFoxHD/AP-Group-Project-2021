package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	
	private Socket connectionSocket;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	
	public Client(){
		try{
	    	connectionSocket = new Socket("127.0.0.1",8888);
            this.objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
            this.objIs = new ObjectInputStream(connectionSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
	        
	}
	  
    public void closeConnection(){
        try{
            objOs.close();
            objIs.close();
            connectionSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
	    
    public void sendAction(String action) {
    	try {
    		objOs.writeObject(action);
    	}catch (IOException e) {
    		e.printStackTrace(); 
    	} 
    }
    
    public void response(String action) {
    	String response = "";
    	try {
    		response = (String) objIs.readObject();
    	}catch (IOException | ClassNotFoundException e) {
    		e.printStackTrace(); 
    	}
    	
    	System.out.println("[SERVER - response] "+ response);
    }
	    
	    
}
