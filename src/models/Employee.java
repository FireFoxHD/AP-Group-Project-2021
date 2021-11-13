package models;

public class Employee {
	private String id;
	private String firstname;
	private String lastname;
	private Role role;
	
	public Employee() {
		this.id = "";
		this.firstname = "";
		this.lastname = "";
		this.role = null;
	}
	
	public Employee(String id, String firstname, String lastname, Role role) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
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

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tName: " + this.firstname +" "+this.lastname + "\t Role: "+this.role.toString();
		
	}
	
}
