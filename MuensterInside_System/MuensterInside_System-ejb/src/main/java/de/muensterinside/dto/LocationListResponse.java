package de.muensterinside.dto;

import java.util.List;

/**
 * @author Lennart Giesen
 */
public class LocationListResponse extends ReturncodeResponse{

	
	private List<LocationTO> locationList;
	

	public List<LocationTO> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<LocationTO> locationList) {
		this.locationList = locationList;
	}
}
