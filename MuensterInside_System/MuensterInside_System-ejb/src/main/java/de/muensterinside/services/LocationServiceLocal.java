package de.muensterinside.services;

import javax.ejb.Local;

import de.muensterinside.dto.ImageResponse;
import de.muensterinside.dto.LocationListResponse;
import de.muensterinside.dto.LocationResponse;
import de.muensterinside.dto.ReturncodeResponse;

/**
 * Diese Bean stellt die Operation für die Location bereit, wie anlegen, ausgeben und Bild-Upload. 
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface LocationServiceLocal {

	/**
	 * Gibt eine Location anhand der Id zurück.
	 * @param id ID der Location
	 * @return LocationResponse-Objekt
	 */
	public LocationResponse getLocation(int id);
	
	/**
	 * Gibt eine Liste von Location eines Gerätes(Android-ID) zurück.
	 * @param deviceId Id des Gerätes(Nicht die Android-ID)
	 * @return LocationListResponse-Objekt
	 */
	public LocationListResponse getMyLocations(int deviceId);
	
	/**
	 * Gibt eine Liste von Location einer Kategorie zurück.
	 * @param cat_id Id der Kategorie
	 * @return LocationListResponse-Objekt
	 */
	public LocationListResponse getLocationsByCategory(int cat_id);

	/**
	 * Speichern eine Location
	 * @param name Name der Location
	 * @param description Beschreibung der Location
	 * @param link Webseite der Location
	 * @param category_id Id der Kategorie
	 * @param deviceId Id des Devices(Nicht Android-ID)
	 * @return ReturncodeReponse-Objekt
	 */
	public ReturncodeResponse saveLocation(String name, String description, String link, int category_id,
			int deviceId);

	/**
	 * Upload eines Bildes für eine Location
	 * @param location_id Id der Location
	 * @param mimeType Bild-Typ
	 * @param imageDataBase64 Bilddaten im Base64-String
	 * @return
	 */
	public ReturncodeResponse uploadImage(int location_id, String mimeType, String imageDataBase64);

	/**
	 * Download eines Bildes von einer Location
	 * @param location_id Id der Location
	 * @return ImageResponse-Objekt
	 */
	public ImageResponse downloadImage(int location_id);
}
