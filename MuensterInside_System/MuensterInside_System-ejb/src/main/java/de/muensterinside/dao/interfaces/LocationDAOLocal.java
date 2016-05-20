package de.muensterinside.dao.interfaces;

import java.util.List;

import javax.ejb.Local;
import de.muensterinside.entities.Location;;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Local
public interface LocationDAOLocal {
	
	List<Location> findAll();
	
	Location findById(int id);
	
	List<Location> findByCategory(int cat_id);
	
	boolean insert(Location loc);
	
	Location update(Location loc);
	
	boolean delete(int location_id);

	boolean isExists(int locationId);

	List<Location> findByDevice(int deviceId);

}
