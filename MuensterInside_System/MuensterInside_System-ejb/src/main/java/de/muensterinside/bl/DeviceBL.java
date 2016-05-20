package de.muensterinside.bl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import de.muensterinside.bl.interfaces.DeviceBLLocal;
import de.muensterinside.dao.interfaces.DeviceDAOLocal;
import de.muensterinside.dto.DeviceResponse;
import de.muensterinside.entities.Device;
import de.muensterinside.exceptions.DeviceExistsException;
import de.muensterinside.exceptions.DeviceNotFoundException;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;

//TODO: Klasse kommentieren
@Stateless
public class DeviceBL implements DeviceBLLocal {

	private static final Logger logger = Logger.getLogger(DeviceBL.class);

	@EJB
	DeviceDAOLocal daoDevice;

	@EJB
	DtoAssembler dtoAssembler;

	@Override
	public DeviceResponse register(String androidUuid, String username) {
		DeviceResponse response = new DeviceResponse();

		try {
			// Überprüfen ob für dieses Uuid schon ein Device registriert wurde.
			if (daoDevice.findByAndroidUuid(androidUuid) != null)
				throw new DeviceExistsException("Dieses Gerät(" + androidUuid + ") wurde schon registriert");

			Device dev = new Device(androidUuid, username);
			daoDevice.insert(dev);
			response.setDevice(dtoAssembler.makeDTO(dev));
			logger.info("Ein Device(" + androidUuid + "," + username + ") wurde gespeichert");
		} catch (MuensterInsideException e) {
			logger.error("Fehler " + e.getErrorCode() + ": " + e.getMessage());
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.fatal("Unbekannter Fehler " + Messages.SystemErrorCode + ":" + e.getMessage());
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	@Override
	public DeviceResponse login(String androidUuid) {
		DeviceResponse response = new DeviceResponse();

		try {
			Device dev = daoDevice.findByAndroidUuid(androidUuid);

			// Überprüfen ob das Gerät registriert ist
			if (dev == null)
				throw new DeviceNotFoundException("Das Gerät(" + androidUuid + ") ist nicht registriert");

			// Login-Datum aktualisieren
			dev.setLastLoginAt();
			daoDevice.update(dev);
			response.setMessage("Wilkommen  " + dev.getUsername() + "!");
			response.setDevice(dtoAssembler.makeDTO(dev));

		} catch (MuensterInsideException e) {
			logger.error("Fehler " + e.getErrorCode() + ": " + e.getMessage());
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.fatal("Unbekannter Fehler " + Messages.SystemErrorCode + ":" + e.getMessage());
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}
}
