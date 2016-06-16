package de.muensterinside.dto;

/**
 * @author Lennart Giesen, Julius Wessing
 */
public class DeviceTO {
	
	private int id;
	
	private String androidUuid;
	
	private String username;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAndroidUuid() {
		return androidUuid;
	}

	public void setAndroidUuid(String androidUuid) {
		this.androidUuid = androidUuid;
	}


}
