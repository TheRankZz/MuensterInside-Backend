package de.muensterinside.services;

import javax.ejb.Local;

import de.muensterinside.dto.CommentListResponse;
import de.muensterinside.dto.ReturncodeResponse;

/**
 * Diese Bean kümmert sich um das ausgeben, anlegen und löschen von Kommentaren.
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface CommentServiceLocal {

	/**
	 * Gibt eine Liste von Kommentaren einer Location zurück.
	 * @param loc_id Id von der Location
	 * @return Liste von Kommentaren
	 */
	public CommentListResponse getCommentsByLocation(int loc_id);

	/**
	 * Gibt eine Liste von Kommentaren eines Benutzers bzw. Android-Gerätes zurück.
	 * @param deviceId Android-ID
	 * @return Liste von Kommentaren
	 */
	public CommentListResponse getMyComments(int deviceId);

	/**
	 * Speichert ein Kommentar
	 * @param text Kommentartext
	 * @param deviceId Android-ID
	 * @param locationId Id der Location
	 * @return Rückgabe eines ReturnCode
	 */
	public ReturncodeResponse saveComment(String text, int deviceId, int locationId);

	/**
	 * Löschen eines Kommentares
	 * @param comment_id Id des KOmmentars
	 * @return Rückgabe eines ReturnCode
	 */
	public ReturncodeResponse deleteComment(int comment_id);
}
