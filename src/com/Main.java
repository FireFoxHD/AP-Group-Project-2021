package main;

import java.time.LocalDateTime;
import models.*;

public class main {

		
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		Order ord = new Order("", "", "", "", now, now.plusDays(15));
		Customer cust = new Customer("001", "rick grimes", "password", ord ,5000.00);
		
		
	}


}
