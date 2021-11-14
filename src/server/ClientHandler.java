package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import controllers.CustomerController;
import controllers.EmployeeController;
import controllers.ItemController;
import controllers.OrderController;
import controllers.PasswordController;
import models.Actions;
import models.Customer;
import models.Order;

public class ClientHandler extends Thread{

	private Socket client;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	
	public ClientHandler(Socket clientSocket){
		this.client = clientSocket;
		configureStreams();
		new EmployeeController();
		new CustomerController();
		new OrderController();
		new ItemController();
		new PasswordController();
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
				Actions action = (Actions) objIs.readObject();
				
				//CUSTOMER ACTIONS
				if(action == Actions.CREATE_CUSTOMER) {
					
				}
				
				if(action == Actions.UPDATE_CUSTOMER) {
					
				}
				
				if(action == Actions.UPDATE_CUSTOMER_BALANCE) {
					
				}
				
				if(action == Actions.READ_CUSTOMER) {
					String id = (String) objIs.readObject();
					Customer customer = CustomerController.read(id);
					objOs.writeObject(customer);
				}

				if(action == Actions.READ_ALL_CUSTOMERS) {
					ArrayList<Customer> customers = CustomerController.readAll();
					objOs.writeObject(customers);
				}
				
				if(action == Actions.DELETE_CUSTOMER) {
					
				}
				
				//EMPLOYEE ACTIONS
				if(action == Actions.CREATE_EMPLOYEE) {
					
				}
				
				if(action == Actions.UPDATE_EMPLOYEE) {
					
				}
				
				if(action == Actions.READ_EMPLOYEE) {
					
				}

				if(action == Actions.READ_ALL_EMPLOYEES) {
					
				}
				if(action == Actions.DELETE_EMPLOYEE) {
					
				}
				
				//ORDER ACTIONS
				if(action == Actions.CREATE_ORDER) {
					
				}
				
				if(action == Actions.UPDATE_ORDER) {
					
				}

				if(action == Actions.READ_ORDER) {
					String id = (String) objIs.readObject();
					Order order = OrderController.read(id);
					objOs.writeObject(order);
				}
				
				if(action == Actions.READ_ALL_ORDERS) {
					ArrayList<Order> orders = OrderController.readAll();
					objOs.writeObject(orders);
				}
				
				if(action == Actions.DELETE_ORDER) {
					
				}

				//ITEM ACTIONS
				if(action == Actions.CREATE_ITEM) {
					
				}
				
				if(action == Actions.UPDATE_ITEM) {
					
				}

				if(action == Actions.READ_ITEM) {
					
				}
				
				if(action == Actions.READ_ALL_ITEMS) {
					
				}
				
				if(action == Actions.DELETE_ITEM) {
					
				}
				
				//PASSWORD ACTIONS
				if(action == Actions.VALIDATE_PASSWORD) {
					String id = (String) objIs.readObject();
					String password = (String) objIs.readObject();
					System.out.println("ID: "+ id);
					System.out.println("PAss: "+ password);
					Boolean isValid = PasswordController.validate(id, password);
					System.out.println("VALIDATION: "+ isValid);
					objOs.writeObject(isValid);
				}
				
				if(action == Actions.UPDATE_PASSWORD) {
									
				}
				
				if(action == Actions.DELETE_PASSWORD) {
					
				}

				
				//LOGIN
				if(action == Actions.LOGIN) {
					
				}
				
			}
		}catch(IOException e) {
			System.err.println("Issue running in Client handler");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
