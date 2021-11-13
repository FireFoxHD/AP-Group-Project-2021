package models;

import java.sql.*;

public class Order {
	private String id;
	private String customerId;
	private String employeeId;
	private Status status;
	private Date dateOfRental;
	private Date dateOfReturn;

	
	public Order() {
		this.id = "";
		this.customerId = "";
		this.employeeId = "";
		this.setStatus(null);
		this.dateOfRental = null;
		this.dateOfReturn = null;
	}
	
	
	public Order(String id, String customerId, String employeeId, Date dateOfReturn) {
		this.id = id;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.setStatus(Status.PENDING);
		this.dateOfRental = new Date(System.currentTimeMillis());
		this.dateOfReturn = dateOfReturn;
	}
	
	public Order(String id, String customerId, String employeeId, Status status, Date dateOfRental, Date dateOfReturn) {
		this.id = id;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.setStatus(status);
		this.dateOfRental = dateOfRental;
		this.dateOfReturn = dateOfReturn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDateOfRental() {
		return dateOfRental;
	}

	public void setDateOfRental(Date dateOfRental) {
		this.dateOfRental = dateOfRental;
	}

	public Date getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
}
