package de.muensterinside.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import de.muensterinside.dao.CategoryDAOLocal;
import de.muensterinside.dao.DeviceDAOLocal;
import de.muensterinside.dao.LocationDAOLocal;
import de.muensterinside.dto.ImageResponse;
import de.muensterinside.dto.LocationListResponse;
import de.muensterinside.dto.LocationResponse;
import de.muensterinside.dto.ReturncodeResponse;
import de.muensterinside.entities.Category;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;
import de.muensterinside.exceptions.NoSavedException;
import de.muensterinside.exceptions.NotAllowedRequestException;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;

/**
 * siehe Interface-Beschreibung
 * @author Lennart Giesen, Julius Wessing
 */
@Stateless
public class LocationService implements LocationServiceLocal {

	private static final Logger logger = Logger.getLogger(LocationService.class);
	
	@EJB
	LocationDAOLocal locationDAO;

	@EJB
	CategoryDAOLocal categoryDAO;

	@EJB
	DeviceDAOLocal deviceDAO;

	@EJB
	DtoAssembler dtoAssembler;

	@Override
	public LocationListResponse getLocationsByCategory(int cat_id) {
		LocationListResponse response = new LocationListResponse();
		try {
			//Anfrage prüfen
			if(cat_id == 0)
				throw new NotAllowedRequestException(Messages.NOT_ALLOWED_REQUEST_MSG);
			
			//Locations holen
			List<Location> locationList = locationDAO.findByCategory(cat_id);

			if (locationList.isEmpty()) {
				throw new NoDataException(Messages.NO_DATA_EXCEPTION_MSG);
			}

			response.setLocationList(dtoAssembler.makeDTOLocationList(locationList));

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
	public ReturncodeResponse saveLocation(String name, String description, String link, int category_id,
			int deviceId) {

		ReturncodeResponse response = new ReturncodeResponse();
		
		try {
			//Anfrage prüfen
			if(name == null || name.isEmpty() || category_id == 0 || deviceId == 0) 
				throw new NotAllowedRequestException(Messages.NOT_ALLOWED_REQUEST_MSG);
		
			if (!categoryDAO.isExists(category_id))
				throw new NoDataException(Messages.NO_DATA_EXCEPTION_MSG);
			
			if (!deviceDAO.isExists(deviceId))
				throw new NoDataException(Messages.NO_DATA_EXCEPTION_MSG);

			Category category = categoryDAO.findByID(category_id);
			Device device = deviceDAO.findByID(deviceId);

			Location location = new Location(name, description, link, device, category);

			//Location speichern und prüfen ob Speichern erfolgreich war.
			if (!locationDAO.insert(location))
				throw new NoSavedException(Messages.NO_SAVED_EXCEPTION_MSG);
			
			logger.info("Location(" + name + ") wurde angelegt");
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
	public LocationResponse getLocation(int id) {
		LocationResponse response = new LocationResponse();
		
		try {
			//Anfrage prüfen
			if(id == 0)
				throw new NotAllowedRequestException(Messages.NOT_ALLOWED_REQUEST_MSG);
			
			Location loc = locationDAO.findById(id);
			if(loc == null) 
				throw new NoDataException(Messages.NO_DATA_EXCEPTION_MSG);
			
			response.setLocation(dtoAssembler.makeDTO(loc));
			
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
	public LocationListResponse getMyLocations(int deviceId) {
		LocationListResponse response = new LocationListResponse();
		
		try {
			//Anfrage prüfen
			if(deviceId == 0)
				throw new NotAllowedRequestException(Messages.NOT_ALLOWED_REQUEST_MSG);
			
			//Location holen
			List<Location> locations = locationDAO.findByDevice(deviceId);
			
			if(locations.isEmpty())
				throw new NoDataException(Messages.NO_DATA_EXCEPTION_MSG);
			
			response.setLocationList(dtoAssembler.makeDTOLocationList(locations));
			
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
	public ReturncodeResponse uploadImage(int location_id, String mimeType, String imageDataBase64) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageResponse downloadImage(int location_id) {
		// TODO Auto-generated method stub
		return null;
	}
}
