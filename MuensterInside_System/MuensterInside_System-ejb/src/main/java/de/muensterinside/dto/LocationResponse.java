package de.muensterinside.dto;

public class LocationResponse extends ReturncodeResponse {
	
	private LocationTO location;

	public LocationTO getLocation() {
		return location;
	}

	public void setLocation(LocationTO location) {
		this.location = location;
	}
}
