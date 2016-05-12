package de.muensterinside.dto;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
public class DeviceTO {

	private int id;
	private String firstname;
	private String lastname;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
}
