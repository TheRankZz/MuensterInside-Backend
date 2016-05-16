package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.muensterinside.bl.interfaces.LocationBLLocal;
import de.muensterinside.dao.interfaces.CategoryDAOLocal;
import de.muensterinside.dao.interfaces.DeviceDAOLocal;
import de.muensterinside.dao.interfaces.LocationDAOLocal;
import de.muensterinside.dto.LocationListResponse;
import de.muensterinside.dto.ReturncodeResponse;
import de.muensterinside.entities.Category;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;
import de.muensterinside.exceptions.NoSavedException;
import de.muensterinside.util.DtoAssembler;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */

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
				throw new NoDataException("Keine Location gefunden.");
			}

			response.setLocationList(dtoAssembler.makeDTOLocationList(locationList));

		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * 
	 */
	public ReturncodeResponse saveLocation(String name, String description, String link, int category_id,
			String deviceId) {

		ReturncodeResponse response = new ReturncodeResponse();

		try {
			if (!categoryDAO.isExists(category_id))
				throw new NoDataException("Keine Category gefunden.");
			if (!deviceDAO.isExists(deviceId))
				throw new NoDataException("Kein Device gefunden.");

			Category category = categoryDAO.findByID(category_id);
			Device device = deviceDAO.findByDeviceId(deviceId);

			Location location = new Location(name, description, link, device, category);

			if (!locationDAO.insert(location))
				throw new NoSavedException("Konnte nicht gespeichert werden.");

		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}

		return response;
	}
}
