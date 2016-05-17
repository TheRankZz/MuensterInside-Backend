package de.muensterinside.bl.interfaces;

import javax.ejb.Local;

import de.muensterinside.dto.ImageResponse;
import de.muensterinside.dto.LocationListResponse;
import de.muensterinside.dto.ReturncodeResponse;

@Local
public interface LocationBLLocal {

	public LocationListResponse getLocationsByCategory(int cat_id);

	public ReturncodeResponse saveLocation(String name, String description, String link, int category_id,
			String deviceId);

	public ReturncodeResponse uploadImage(int location_id, byte[] imageBytes);

	public ImageResponse downloadImage(int location_id);
}
