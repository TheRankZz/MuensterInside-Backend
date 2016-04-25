package de.muensterinside.shared.interfaces;

import java.util.List;

import de.muensterinside.shared.entities.Location;

/**
 * Dieses Business Interface ist zuständig für die Locations.
 * @author Lennart Giesen, Julius Wessing
 *
 */
public interface LocationService {
	
	/**
	 * Gibt die Location anhand der Id zurück.
	 * @param loc_id
	 * @return
	 */
	public Location getLocation(int loc_id);
	
	/**
	 * Gibt alle Locations zurück
	 * @return
	 */
	public List<Location> getAllLocation();
	
	/**
	 * Gibt alle Locations anhand der Kategorie zurück.
	 * @param cat_id
	 * @return
	 */
	public List<Location> getLocationByCategory(int cat_id);
	
	/**
	 * Gibt alle Locations anhand des Gerätes zurück.
	 * @param deviceId
	 * @return
	 */
	public List<Location> getMyLocation(String deviceId);
	
	/**
	 * Neue Location hinzufügen.
	 * @param loc
	 * @return
	 */
	public boolean addLocation(Location loc);
	
	/**
	 * Löscht eine Location anhand der Id.
	 * @param loc_id
	 * @return
	 */
	public boolean removeLocation(int loc_id);

}
