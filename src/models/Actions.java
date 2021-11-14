package models;

import java.io.Serializable;

public enum Actions implements Serializable{
	LOGIN,
	CREATE_ORDER,
	CREATE_ORDER_NOW,
	UPDATE_ORDER,
	READ_ORDER,
	READ_ALL_ORDERS,
	DELETE_ORDER,
	CREATE_CUSTOMER,
	UPDATE_CUSTOMER,
	UPDATE_CUSTOMER_BALANCE,
	READ_CUSTOMER,
	READ_ALL_CUSTOMERS,
	DELETE_CUSTOMER,
	CREATE_EMPLOYEE,
	UPDATE_EMPLOYEE,
	READ_EMPLOYEE,
	READ_ALL_EMPLOYEES,
	DELETE_EMPLOYEE,
	CREATE_ITEM,
	UPDATE_ITEM,
	READ_ITEM,
	READ_ALL_ITEMS,
	DELETE_ITEM,
	VALIDATE_PASSWORD,
	UPDATE_PASSWORD,
	DELETE_PASSWORD
}
