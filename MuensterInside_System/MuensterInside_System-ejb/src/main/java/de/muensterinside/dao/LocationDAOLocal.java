package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Local;
import de.muensterinside.entities.Location;;

/**
 * DAO für Location
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface LocationDAOLocal {
	
	/**
	 * Gibt eine Liste von allen Locations zurück
	 * @return Liste von Location
	 */
	List<Location> findAll();
	
	/**
	 * Findet eine Location anhand der Id
	 * @param id
	 * @return Location-Objekt
	 */
	Location findById(int id);
	
	/**
	 * Gibt eine Liste von Location einer Kategorie zurück
	 * @param cat_id Category.id
	 * @return Liste von Locations
	 */
	List<Location> findByCategory(int cat_id);
	
	/**
	 * Eine Location in die DB hinzufügen
	 * @param loc
	 * @return true, wenn das hinzufügen erfolgreich war, andernfalls false
	 */
	boolean insert(Location loc);
	
	/**
	 * Erzwingt aktualisieren eines Location-Objekt in der DB, falls es Detached ist
	 * @param loc Location-Objekt
	 * @return Location-Objekt
	 */
	Location update(Location loc);
	
	/**
	 * Löscht eine Location 
	 * @param location_id Location.id
	 * @return true wenn es erfolgreich war, andernfalls false
	 */
	boolean delete(int location_id);

	/**
	 * Prüft ob die Location in der DB vorhanden ist
	 * @param locationId Location.id
	 * @return true wenn es in der Db vorhanden ist, andernfalls false
	 */
	boolean isExists(int locationId);
	
	/**
	 * Gibt Locations eines Device zurück
	 * @param deviceId Device.id
	 * @return Liste von Location
	 */
	List<Location> findByDevice(int deviceId);
}
