package de.muensterinside.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import de.muensterinside.dao.DeviceDAOLocal;
import de.muensterinside.dto.DeviceResponse;
import de.muensterinside.entities.Device;
import de.muensterinside.exceptions.DeviceExistsException;
import de.muensterinside.exceptions.DeviceNotFoundException;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NotAllowedRequestException;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;
import de.muensterinside.util.OutputRequesterBean;

/**
 * siehe Interface-Beschreibung
 * @author Lennart Giesen, Julius Wessing
 */
@Stateless
public class DeviceService implements DeviceServiceLocal {

	private static final Logger logger = Logger.getLogger(DeviceService.class);

	@EJB
	DeviceDAOLocal daoDevice;

	@EJB
	DtoAssembler dtoAssembler;
	
	@EJB
	private OutputRequesterBean outputRequester;

	@Override
	public DeviceResponse register(String androidUuid, String username) {
		DeviceResponse response = new DeviceResponse();

		try {
			//Anfrage prüfen
			androidUuid = androidUuid.trim();
			username = username.trim();
			
			if(androidUuid.isEmpty() || username.isEmpty())
				throw new NotAllowedRequestException(Messages.NOT_ALLOWED_REQUEST_MSG);
			
			//Prüfen ob für dieses Android-ID schon ein Device registriert wurde
			if (daoDevice.findByAndroidUuid(androidUuid) != null)
				throw new DeviceExistsException(String.format(Messages.DEVICE_EXISTS_EXCEPTION_MSG, androidUuid));

			//Device-Objekt erstellen und in die DB speichern
			Device dev = new Device(androidUuid, username);
			daoDevice.insert(dev);
			response.setDevice(dtoAssembler.makeDTO(dev));
			
			logger.info("Ein Device(" + androidUuid + "," + username + ") wurde gespeichert");
		} catch (MuensterInsideException e) {
			logger.error("Fehler " + e.getErrorCode() + ": " + e.getMessage());
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.fatal("Unbekannter Fehler " + Messages.SYSTEM_ERROR_CODE + ":" + e.getMessage());
			response.setReturnCode(Messages.SYSTEM_ERROR_CODE);
			response.setMessage(Messages.SYSTEM_ERROR_MSG);
		}

		return response;
	}

	@Override
	public DeviceResponse login(String androidUuid) {
		DeviceResponse response = new DeviceResponse();

		try {
			//Anfrage prüfen
			androidUuid = androidUuid.trim();
			if(androidUuid.isEmpty())
				throw new NotAllowedRequestException(Messages.NOT_ALLOWED_REQUEST_MSG);
			
			//Device-Objekt holen
			Device dev = daoDevice.findByAndroidUuid(androidUuid);

			// Überprüfen ob das Gerät registriert ist
			if (dev == null)
				throw new DeviceNotFoundException(String.format(Messages.DEVICE_NOT_FOUND_EXCEPTION_MSG, androidUuid));

			// Login-Datum aktualisieren
			dev.setLastLoginAt();
			daoDevice.update(dev);
			
			//Java-Messages-Bean 
			outputRequester.printLog("Der Benutzer(" + dev.getUsername() + ") mit der Android-ID(" +
					dev.getAndroidUuid() + ") hat sich eingeloggt.");
			
			response.setMessage("Wilkommen  " + dev.getUsername() + "!");
			response.setDevice(dtoAssembler.makeDTO(dev));

		} catch (MuensterInsideException e) {
			logger.error("Fehler " + e.getErrorCode() + ": " + e.getMessage());
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.fatal("Unbekannter Fehler " + Messages.SYSTEM_ERROR_CODE + ":" + e.getMessage());
			response.setReturnCode(Messages.SYSTEM_ERROR_CODE);
			response.setMessage(Messages.SYSTEM_ERROR_MSG);
		}

		return response;
	}
}
