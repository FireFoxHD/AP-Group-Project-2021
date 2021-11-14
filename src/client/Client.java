package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import models.Actions;

public class Client {
	
	private static Socket connectionSocket;
	private static ObjectOutputStream outStream;
	private static ObjectInputStream inStream;
	private static BufferedReader br;
	private static String action = null;
	
	public Client(){
		action = null;
		try{
	    	connectionSocket = new Socket("127.0.0.1",8888);
	    	outStream = new ObjectOutputStream(connectionSocket.getOutputStream());
	    	inStream = new ObjectInputStream(connectionSocket.getInputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) throws IOException{
		
		
		while(true) {
			if (action == null) {
				System.out.println("Enter action :");
				action = br.readLine();
				outStream.flush();
			}
			
			String serverMessage = inStream.readUTF();
			System.out.println("[SERVER] "+serverMessage);
		}
		//closeConnection();
	        
	}
	
	 public void sendAction(Actions action) {
    	try {
    		outStream.writeObject(action);
    	}catch (IOException e) {
    		e.printStackTrace(); 
    	} 
     }
	 
	 public <T> void send(T parameter) {
    	try {
    		outStream.writeObject(parameter);
    	}catch (IOException e) {
    		e.printStackTrace(); 
    	} 
     }
	 
	 public <T> void sendMultiple(List<T> parameters) {
    	try {
    		for(T param : parameters) {
    			outStream.writeObject(param);
    		}
    	}catch (IOException e) {
    		e.printStackTrace(); 
    	} 
     }

    public <T> Object getResponse() {
    	Object response = null;
    	try {
    		response =  inStream.readObject();
    	}catch (IOException | ClassNotFoundException e) {
    		e.printStackTrace(); 
    	}
    	System.out.println("[SERVER] Sending Response ...");
		return response;
    }
	  

	public static void closeConnection(){
        try{
        	outStream.close();
        	inStream.close();
            connectionSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
	   
	    
}
