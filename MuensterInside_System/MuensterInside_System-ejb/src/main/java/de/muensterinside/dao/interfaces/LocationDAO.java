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
public interface LocationDAO {
	
	List<Location> findAll();
	
	Location findById(int id);
	
	boolean insert(Location loc);
	
	Location update(Location loc);
	
	boolean delete(int location_id);

}
