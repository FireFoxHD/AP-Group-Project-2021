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
			System.out.println("Enter action :");
			String action = br.readLine();
			outStream.writeUTF(action);
			outStream.flush();
			
			String serverMessage = inStream.readUTF();
			System.out.println(serverMessage);
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
