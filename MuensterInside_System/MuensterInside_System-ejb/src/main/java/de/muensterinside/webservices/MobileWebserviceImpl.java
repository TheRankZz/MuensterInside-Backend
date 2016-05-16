package de.muensterinside.webservices;

import java.util.List;

import javax.ejb.EJB;

import de.muensterinside.dto.CategoryListResponse;
import de.muensterinside.dto.LocationListResponse;
import de.muensterinside.dto.ReturncodeResponse;
import de.muensterinside.entities.*;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.dao.*;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
public class MobileWebserviceImpl {

	@EJB
	private CategoryDAO categoryDAO;
	
	@EJB 
	private DeviceDAO deviceDAO;
	
	@EJB
	private DtoAssembler dtoAssembler;
	
	@EJB
	private LocationDAO locationDAO;
	
	public CategoryListResponse getCategories() {
		CategoryListResponse response = new CategoryListResponse();
		
		List<Category> categoryList = categoryDAO.findAll();
		
		response.setCategoryList(dtoAssembler.makeDTO(categoryList));
		
		return response;	
	}
	
	public LocationListResponse getLocationsByCategory(int cat_id) {
		LocationListResponse response = new LocationListResponse();
		
		List<Location> locationList = locationDAO.getLocationsByCategory(cat_id);
		
		response.setLocationList(dtoAssembler.makeDTO(locationList));
		
		return response;
	}
	
	public ReturncodeResponse saveLocation(String name, String description, 
			String link, int deviceId, int categoryId){
		
		ReturncodeResponse returncodeResponse = new ReturncodeResponse();
		
		Device device;
		
		Category category = categoryDAO.findByID(categoryId);
		
		if(deviceDAO.isExists(deviceId) == true) {
			device = deviceDAO.findByID(deviceId);
		} else {
			//DEVICE erstellen
		}
		
		Location location = new Location();
	}
}
