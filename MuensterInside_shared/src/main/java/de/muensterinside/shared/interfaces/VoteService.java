package de.muensterinside.shared.interfaces;

import java.util.List;

import de.muensterinside.shared.entities.Location;

/**
 * Dieses Business Interface ist zuständig für die Bewertung.
 * @author Lennart Giesen, Julius Wessing
 *
 */
public interface VoteService {

	/**
	 * Operation zum upvoten einer Location mit speichern der Geräte-Id.
	 * @param location_id
	 * @param deviceId
	 * @return
	 */
	public boolean upVote(int location_id, String deviceId);
	
	/**
	 * Operation zum downvoten einer Location mit speichern der Geräte-Id.
	 * @param location_id
	 * @param deviceId
	 * @return
	 */
	public boolean downVote(int location_id, String deviceId);
	
	/**
	 * Gibt zurück ob für diese Location mit dieser Geräte-Id ein Vote abgegeben wurde.
	 * @param location_id
	 * @param deviceId
	 * @return
	 */
	public boolean isVoted(int location_id, String deviceId);
	
	/**
	 * Gibt alle Votes von einem Gerät zurück
	 * @param deviceId
	 * @return
	 */
	public List<Location> getMyVotes(String deviceId);
	
}
