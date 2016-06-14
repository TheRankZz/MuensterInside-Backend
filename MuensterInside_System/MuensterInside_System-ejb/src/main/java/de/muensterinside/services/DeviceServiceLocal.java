package de.muensterinside.services;

import javax.ejb.Local;

import de.muensterinside.dto.DeviceResponse;

/**
 * Diese Bean stellt die Operationen für Device(Android-Geräte) bereit.
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface DeviceServiceLocal {

	/**
	 * Ein neues Android-Gerät registrieren.
	 * @param deviceId Android-ID
	 * @param username Benutzername
	 * @return Device-Objekt
	 */
	public DeviceResponse register(String deviceId, String username);

	/**
	 * Gibt anhand der Android-ID das Device-Objekt zurück.
	 * @param deviceId Android-ID
	 * @return Device-Objekt
	 */
	public DeviceResponse login(String deviceId);

}
