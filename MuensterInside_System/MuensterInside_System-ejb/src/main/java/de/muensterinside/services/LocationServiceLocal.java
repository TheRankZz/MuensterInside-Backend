package de.muensterinside.services;

import javax.ejb.Local;

import de.muensterinside.dto.ImageResponse;
import de.muensterinside.dto.LocationListResponse;
import de.muensterinside.dto.LocationResponse;
import de.muensterinside.dto.ReturncodeResponse;

@Local
public interface LocationServiceLocal {

	public LocationResponse getLocation(int id);
	
	public LocationListResponse getMyLocations(int deviceId);
	
	public LocationListResponse getLocationsByCategory(int cat_id);

	public ReturncodeResponse saveLocation(String name, String description, String link, int category_id,
			int deviceId);

	public ReturncodeResponse uploadImage(int location_id, String mimeType, String imageDataBase64);

	public ImageResponse downloadImage(int location_id);
}
