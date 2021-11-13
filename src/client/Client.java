package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	
	private static Socket connectionSocket;
	private static ObjectOutputStream outStream;
	private static ObjectInputStream inStream;
	private static BufferedReader br;
	private static String action = null;
	
	private Client(){
		action = null;
	}
	
	public static void main(String[] args) throws IOException{
		try{
	    	connectionSocket = new Socket("127.0.0.1",8888);
	    	outStream = new ObjectOutputStream(connectionSocket.getOutputStream());
	    	inStream = new ObjectInputStream(connectionSocket.getInputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
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
