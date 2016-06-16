package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Device;

/**
 * DAO für Device
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface DeviceDAOLocal {

	/**
	 * Gibt ein Device anhand der Id zurueck
	 * @param id Id des Device
	 * @return Device-Objekt
	 */
	public Device findByID(int id);

	/**
	 * Gibt ein Device anhand der Android-ID zurueck
	 * @param uuid Android-ID
	 * @return Device-Objekt
	 */
	public Device findByAndroidUuid(String uuid);

	/**
	 * Gibt eine Liste von allen Devices zurueck
	 * @return Liste von Device
	 */
	public List<Device> findAll();

	/**
	 * Ein Device in die db hunzufuegen
	 * @param device
	 * @return
	 */
	public boolean insert(Device device);

	/**
	 * Erwzingt aktualisieren des Device-Objektes in der DB. 
	 * @param device
	 * @return
	 */
	public Device update(Device device);

	/**
	 * Löscht ein Device in der db 
	 * @param id Device.id
	 * @return true, wenn löschen erfolgreich, andernfalls false
	 */
	public boolean delete(int id);

	/**
	 * Prüft ob ein Device in der Db vorhanden ist
	 * @param deviceId Device.id
	 * @return true, wenn es in der db vorhanden ist, andernfalls false
	 */
	public boolean isExists(int deviceId);
}
