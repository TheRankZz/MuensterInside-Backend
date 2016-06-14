package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Comment;

/**
 * DAO für Kommentare
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface CommentDAOLocal {

	/**
	 * Gibt einen Kommentar anhand der ID.
	 * @param id Id des Kommentars
	 * @return 
	 */
	public Comment findByID(int id);
	
	/**
	 * Gibt alle Kommentare zurück
	 * @return Liste von Kommentaren
	 */
	public List<Comment> findAll();
	
	/**
	 * Gibt Kommentare einer Location zurück.
	 * @param loc_id Id der Location
	 * @return Liste von Kommentaren
	 */
	public List<Comment> findByLocation(int loc_id);
	
	/**
	 * Kommentar in die Db hinzufügen
	 * @param comment Kommentar-Objekt
	 * @return true, falls hinzufügen erfolgreich war, andernfalls false
	 */
	public boolean insert(Comment comment);
	
	/**
	 * Kommentar in der db aktualisieren erzwingen, falls das Objekt Detached ist.
	 * @param comment Kommentar-Objekt
	 * @return Kommentar-Objekt
	 */
	public Comment update(Comment comment);
	
	/**
	 * Ein Kommentar in der DB löschen anhand der Id.
	 * @param comment_id Id des Kommentars
	 * @return true, wenn es erfolgreich war, andernfalls false
	 */
	public boolean delete(int comment_id);

	/**
	 * Gibt eine Liste von Kommentaren von einem Device zurück 
	 * @param dev_id Id des Device
	 * @return Liste von Kommentaren
	 */
	List<Comment> findByDevice(int dev_id);
}
