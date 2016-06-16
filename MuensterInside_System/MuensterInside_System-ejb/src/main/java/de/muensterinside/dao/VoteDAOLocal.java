package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Vote;

/**
 * DAO für Vote
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface VoteDAOLocal {
	
	/**
	 * Gibt alle Votes zurück
	 * @return Liste von Votes
	 */
	List<Vote> findAll();
	
	/**
	 * Gibt eine Vote anhand der Id zurück.
	 * @param id
	 * @return
	 */
	Vote findById(int id);
	
	/**
	 * Neuen Vote in die DB hinzufügen
	 * @param vote
	 * @return true wenn es erfolgreich war, andernfalls false
	 */
	boolean insert(Vote vote);
	
	/**
	 * Erzwingt aktualisieren des Vote-Objektes in der DB, falls es detached war.
	 * @param vote
	 * @return
	 */
	Vote update(Vote vote);
	
	/**
	 * Löscht ein Vote in der DB
	 * @param vote_id 
	 * @return true wenn es erfolgreich war, andernfalls false
	 */
	boolean delete(int vote_id);

	/**
	 * Findet eine Vote anhand der Location-Id und der Device-Id.
	 * @param location_id 
	 * @param deviceId
	 * @return Vote-Objekt
	 */
	Vote findByLocationAndDevice(int location_id, int deviceId);

}
