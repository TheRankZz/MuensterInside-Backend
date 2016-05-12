package de.muensterinside.dto;

import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
public class CommentTO {

	private int id;
	private String text;
	private Location location;
	private Device device;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
}
