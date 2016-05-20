package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.muensterinside.bl.interfaces.LocationBLLocal;
import de.muensterinside.dao.interfaces.CategoryDAOLocal;
import de.muensterinside.dao.interfaces.DeviceDAOLocal;
import de.muensterinside.dao.interfaces.LocationDAOLocal;
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
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */

//TODO: Klasse kommentieren
@Stateless
public class LocationBL implements LocationBLLocal {

	@EJB
	LocationDAOLocal locationDAO;

	@EJB
	CategoryDAOLocal categoryDAO;

	@EJB
	DeviceDAOLocal deviceDAO;

	@EJB
	DtoAssembler dtoAssembler;

	/**
	 * 
	 */
	public LocationListResponse getLocationsByCategory(int cat_id) {
		LocationListResponse response = new LocationListResponse();
		try {
			List<Location> locationList = locationDAO.findByCategory(cat_id);

			if (locationList.isEmpty()) {
				throw new NoDataException(Messages.NoDataExceptionMsg);
			}

			response.setLocationList(dtoAssembler.makeDTOLocationList(locationList));

		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}
		
		return response;
	}

	/**
	 * 
	 */
	public ReturncodeResponse saveLocation(String name, String description, String link, int category_id,
			int deviceId) {

		ReturncodeResponse response = new ReturncodeResponse();

		try {
			if (!categoryDAO.isExists(category_id))
				throw new NoDataException(Messages.NoDataExceptionMsg);
			
			if (!deviceDAO.isExists(deviceId))
				throw new NoDataException(Messages.NoDataExceptionMsg);

			Category category = categoryDAO.findByID(category_id);
			Device device = deviceDAO.findByID(deviceId);

			Location location = new Location(name, description, link, device, category);

			if (!locationDAO.insert(location))
				throw new NoSavedException(Messages.NoSavedExceptionMsg);

		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}



	@Override
	public LocationResponse getLocation(int id) {
		LocationResponse response = new LocationResponse();
		
		try {
			
			Location loc = locationDAO.findById(id);
			if(loc == null) 
				throw new NoDataException(Messages.NoDataExceptionMsg);
			
			response.setLocation(dtoAssembler.makeDTO(loc));
			
		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}
		
		return response;
	}

	@Override
	public LocationListResponse getMyLocations(int deviceId) {
		LocationListResponse response = new LocationListResponse();
		
		try {
			List<Location> locations = locationDAO.findByDevice(deviceId);
			
			if(locations.isEmpty())
				throw new NoDataException(Messages.NoDataExceptionMsg);
			
			response.setLocationList(dtoAssembler.makeDTOLocationList(locations));
			
			
		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
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
