package de.muensterinside.shared.interfaces;

import java.util.List;

import de.muensterinside.system.entities.Comment;

/**
 * Dieses Business Interface ist zuständig für die Kommentare.
 * @author Lennart Giesen, Julius Wessing
 *
 */
public interface CommentService {

	/**
	 * Gibt ein Kommentar anhand der ID zurück.
	 * @param com_id ID vom Kommentar
	 * @return 
	 */
	public Comment getComment(int com_id);
	
	/**
	 * Gibt alle Kommentare von einer Location zurück.
	 * @param loc_id
	 * @return 
	 */
	public List<Comment> getCommentsByLocation(int loc_id);
	
	/**
	 * Gibt die letzten Kommentare von einer Location zurück.
	 * @param loc_id
	 * @return
	 */
	public List<Comment> getLastCommentByLocation(int loc_id);
	
	/**
	 * Gibt alle Kommentare von einem Gerät zurück.
	 * @param deviceId
	 * @return 
	 */
	public List<Comment> getMyComments(String deviceId);
	
	/**
	 * Neuen Kommentar hinzufügen.
	 * @param com
	 * @return 
	 */
	public boolean addComment(Comment com);
	
	/**
	 * Löscht einen Kommentar anhand der Id.
	 * @param com_id
	 * @return
	 */
	public boolean removeComment(int com_id);
	
}
