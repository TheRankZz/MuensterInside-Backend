package de.muensterinside.services;

import javax.ejb.Local;

import de.muensterinside.dto.IsVotedRepsonse;
import de.muensterinside.dto.LocationListResponse;
import de.muensterinside.dto.ReturncodeResponse;

/**
 * Diese Bean stellt die Operationen zum bewerten einer Location bereit.
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface VoteServiceLocal {

	/**
	 * Gibt meine bewerteten Location zurück
	 * @param deviceId Id des Device-Objektes(Nicht die Android-ID)
	 * @return Liste von meine Bewertungen
	 */
	public LocationListResponse getMyVotes(int deviceId);
	
	/**
	 * Eine Location hoch bewerten
	 * @param location_id Id der Location
	 * @param deviceId Id des Device-Objektes(Nicht die Android-ID)
	 * @return Returncode
	 */
	public ReturncodeResponse upVote(int location_id, int deviceId);
	
	/**
	 * Eine Location runter bewerten
	 * @param location_id Id der Location
	 * @param deviceId Id des Device-Objektes(Nicht die Android-ID)
	 * @return Returncode
	 */
	public ReturncodeResponse downVote(int location_id, int deviceId);	
	
	/**
	 * Abfragen ob für diese Location schon eine Bewertung von dem Gerät vorliegt.
	 * @param location_id Id der Location
	 * @param deviceId Id des Device-Objektes
	 * @return IsVotedRepsonse-Objekt
	 */
	public IsVotedRepsonse isVoted(int location_id, int deviceId);
}
