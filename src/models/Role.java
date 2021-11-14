package models;

import java.io.Serializable;

public enum Role implements Serializable{
	EMPLOYEE,		//regular employee can update order records
	SUPERVISOR,		//employee that can update other employee records
	MANAGER,		//can update all records (except passwords) and delete customer and order records
	ADMIN			//full system control (including password updating and employee deletions)
}
