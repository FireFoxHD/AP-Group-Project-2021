package models;

public class Employee {
	private String id;
	private String firstname;
	private String lastname;
	private String password;
	private String role;
	
	public Employee() {
		this.id = "";
		this.firstname = "";
		this.lastname = "";
		this.password = "";
		this.role = "";
	}
	
	public Employee(String id, String firstname, String lastname, String pass, String role) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = pass;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tName: " + this.firstname +" "+this.lastname + "\t pass: "+ this.password + "\t Role: "+this.role;
		
	}
	

	// CRUD operations

	
}
