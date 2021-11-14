package com;

import models.*;
import org.apache.logging.log4j.Logger;

import controllers.CustomerController;
import controllers.EmployeeController;
import controllers.ItemController;
import controllers.OrderController;

import java.sql.Date;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;

public class Main {
	
	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		
		
		
		Date date = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
        c.setTime(date);
		
        c.add(Calendar.DATE, 2);
        Date newDate = new Date(c.getTimeInMillis());
        
		new EmployeeController();
		new CustomerController();
		new OrderController();
		new ItemController();
		EmployeeController.create("0001", "Rick", "Jones","ricky@gbail.com","18765550000", Role.EMPLOYEE,"test");
		CustomerController.create("0001", "Bill", "Nye", "billnye@scienceguy.com","18763141529","customer");
		//OrderController.create("0001","0001","0001", newDate);
		
		
	}


}
