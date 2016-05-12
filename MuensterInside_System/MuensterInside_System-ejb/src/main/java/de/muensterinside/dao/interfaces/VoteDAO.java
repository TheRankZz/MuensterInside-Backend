package de.muensterinside.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Vote;

@Local
public interface VoteDAO {
	
	List<Vote> findAll();
	
	Vote findById(int id);
	
	boolean insert(Vote vote);
	
	boolean update(Vote vote);
	
	boolean delete(int vote_id);

}
