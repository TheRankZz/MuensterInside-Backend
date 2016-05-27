package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Vote;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Local
public interface VoteDAOLocal {
	
	List<Vote> findAll();
	
	Vote findById(int id);
	
	boolean insert(Vote vote);
	
	Vote update(Vote vote);
	
	boolean delete(int vote_id);

	Vote findByLocationAndDevice(int location_id, int deviceId);

}