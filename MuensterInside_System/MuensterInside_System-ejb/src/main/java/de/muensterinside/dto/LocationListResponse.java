package de.muensterinside.dto;

import java.util.List;

import de.muensterinside.exceptions.MuensterInsideException;

public class LocationListResponse extends ReturncodeResponse{

	
	
	private List<LocationTO> locationList;
	
	public LocationListResponse() {
		// TODO Auto-generated constructor stub
	}

	public List<LocationTO> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<LocationTO> locationList) {
		this.locationList = locationList;
	}
}
