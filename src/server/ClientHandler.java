package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;

import controllers.CustomerController;
import controllers.EmployeeController;
import controllers.ItemController;
import controllers.OrderController;
import controllers.PasswordController;
import models.Actions;
import models.Customer;
import models.Employee;
import models.Item;
import models.Order;
import models.Role;
import models.Status;

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
					String id = (String) objIs.readObject();
					String firstname = (String) objIs.readObject();
					String lastname = (String) objIs.readObject();
					String email = (String) objIs.readObject();
					String phoneNumber = (String) objIs.readObject();
					String pass = (String) objIs.readObject();
					Boolean isCreated = CustomerController.create(id, firstname, lastname, email, phoneNumber, pass);
					objOs.writeObject(isCreated);
				}
				
				if(action == Actions.UPDATE_CUSTOMER) {
					//String id, String firstname, String lastname, String email, String phoneNumber, double bal
					String id = (String) objIs.readObject();
					String firstname = (String) objIs.readObject();
					String lastname = (String) objIs.readObject();
					String email = (String) objIs.readObject();
					String phoneNumber = (String) objIs.readObject();
					double bal = (double) objIs.readObject();
					Boolean isUpdated = CustomerController.update(id, firstname, lastname, email, phoneNumber, bal);
					objOs.writeObject(isUpdated);
				}
				
				if(action == Actions.UPDATE_CUSTOMER_BALANCE) {
					String id = (String) objIs.readObject();
					double balance = (double) objIs.readObject();
					Boolean isUpdated = CustomerController.updateBalance(id, balance);
					objOs.writeObject(isUpdated);
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
					String id = (String) objIs.readObject();
					Boolean isDeleted = CustomerController.delete(id);
					objOs.writeObject(isDeleted);
				}
				
				//EMPLOYEE ACTIONS
				if(action == Actions.CREATE_EMPLOYEE) {
					//String id, String firstname, String lastname, String email, String phoneNumber, Role role, String pass
					String id = (String) objIs.readObject();
					String firstname = (String) objIs.readObject();
					String lastname = (String) objIs.readObject();
					String email = (String) objIs.readObject();
					String phoneNumber = (String) objIs.readObject();
					Role role = (Role) objIs.readObject();
					String pass = (String) objIs.readObject();
					Boolean isCreated = EmployeeController.create(id, firstname, lastname, email, phoneNumber, role, pass);
					objOs.writeObject(isCreated);
				}
				
				if(action == Actions.UPDATE_EMPLOYEE) {
					String id = (String) objIs.readObject();
					String firstname = (String) objIs.readObject();
					String lastname = (String) objIs.readObject();
					String email = (String) objIs.readObject();
					String phoneNumber = (String) objIs.readObject();
					Role role = (Role) objIs.readObject();
					Boolean isUpdated = EmployeeController.update(id, firstname, lastname, email, phoneNumber, role);
					objOs.writeObject(isUpdated);
				}
				
				if(action == Actions.READ_EMPLOYEE) {
					String id = (String) objIs.readObject();
					Employee employee = EmployeeController.read(id);
					objOs.writeObject(employee);
				}

				if(action == Actions.READ_ALL_EMPLOYEES) {
					ArrayList<Employee> employees = EmployeeController.readAll();
					objOs.writeObject(employees);
				}
				
				if(action == Actions.DELETE_EMPLOYEE) {
					String id = (String) objIs.readObject();
					Boolean isDeleted = EmployeeController.delete(id);
					objOs.writeObject(isDeleted);
				}
				
				//ORDER ACTIONS
				if(action == Actions.CREATE_ORDER) {
					String id = (String) objIs.readObject();
					String employeeId = (String) objIs.readObject();
					String custId = (String) objIs.readObject();
					Date dateOfRental = (Date) objIs.readObject();
					Date dateOfReturn = (Date) objIs.readObject();
					Boolean isCreated = OrderController.create(id, custId, employeeId, dateOfRental, dateOfReturn);
					objOs.writeObject(isCreated);
				}
				
				if(action == Actions.CREATE_ORDER_NOW) {
					String id = (String) objIs.readObject();
				    String custId = (String) objIs.readObject();
					String employeeId = (String) objIs.readObject();
					Date dateOfReturn = (Date) objIs.readObject();
					Boolean isCreated = OrderController.createNow(id, custId, employeeId, dateOfReturn);
					objOs.writeObject(isCreated);
				}
				
				if(action == Actions.UPDATE_ORDER) {
					String id = (String) objIs.readObject();
					String employeeId = (String) objIs.readObject();
					Status status = (Status) objIs.readObject();
					Date dateOfReturn = (Date) objIs.readObject();
					Boolean isUpdated = OrderController.update(id, employeeId, status, dateOfReturn);
					objOs.writeObject(isUpdated);
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
					String id = (String) objIs.readObject();
					Boolean isDeleted = OrderController.delete(id);
					objOs.writeObject(isDeleted);
				}

				//ITEM ACTIONS
				if(action == Actions.CREATE_ITEM) {
					String id = (String) objIs.readObject();
					String name = (String) objIs.readObject();
					double cost = (double) objIs.readObject();
					String category = (String) objIs.readObject();
					int numInStock = (int) objIs.readObject();
					Boolean isCreated = ItemController.create(id,name, cost, category, numInStock);
					objOs.writeObject(isCreated);
				}
				
				if(action == Actions.UPDATE_ITEM) {
					String id = (String) objIs.readObject();
					String name = (String) objIs.readObject();
					double cost = (double) objIs.readObject();
					String category = (String) objIs.readObject();
					int numInStock = (int) objIs.readObject();
					Boolean isUpdated = ItemController.update(id,name, cost, category, numInStock);
					objOs.writeObject(isUpdated);
				}

				if(action == Actions.READ_ITEM) {
					String id = (String) objIs.readObject();
					Item item = ItemController.read(id);
					objOs.writeObject(item);
				}
				
				if(action == Actions.READ_ALL_ITEMS) {
					ArrayList<Item> items = ItemController.readAll();
					objOs.writeObject(items);
				}
				
				if(action == Actions.DELETE_ITEM) {
					String id = (String) objIs.readObject();
					Boolean isDeleted = OrderController.delete(id);
					objOs.writeObject(isDeleted);
				}
				
				//PASSWORD ACTIONS
				if(action == Actions.VALIDATE_PASSWORD) {
					String id = (String) objIs.readObject();
					String password = (String) objIs.readObject();
					Boolean isValid = PasswordController.validate(id, password);
					objOs.writeObject(isValid);
				}
				
				if(action == Actions.UPDATE_PASSWORD) {
					String id = (String) objIs.readObject();
					String oldPassword = (String) objIs.readObject();
					String newPassword = (String) objIs.readObject();
					Boolean isUpdated = PasswordController.update(id,oldPassword,newPassword);
					objOs.writeObject(isUpdated);
				}
				
				if(action == Actions.DELETE_PASSWORD) {
					String id = (String) objIs.readObject();
					Boolean isDeleted = PasswordController.delete(id);
					objOs.writeObject(isDeleted);
				}

				
				//LOGIN
				if(action == Actions.LOGIN) {
					String id = (String) objIs.readObject();
					String password = (String) objIs.readObject();
					Boolean isValid = PasswordController.validate(id, password);
					objOs.writeObject(isValid);
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
