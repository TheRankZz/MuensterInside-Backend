package de.muensterinside.dto;

/**
 * @author Lennart Giesen
 */
public class LocationResponse extends ReturncodeResponse {
	
	private LocationTO location;

	public LocationTO getLocation() {
		return location;
	}

	public void setLocation(LocationTO location) {
		this.location = location;
	}
}
