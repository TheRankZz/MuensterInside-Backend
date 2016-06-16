package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Category;

/**
 *  DAO für Kategorien
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface CategoryDAOLocal {

	/**
	 * Findet eine Kategorie anhand der Id
	 * @param id
	 * @return Category-Objekt
	 */
	public Category findByID(int id);
	
	/**
	 * Gibt alle Kategorien zurück
	 * @return Liste von Kategorien
	 */
	public List<Category> findAll();
	
	/**
	 * Neue Kategorie in die DB hinzufügen
	 * @param category
	 * @return
	 */
	public boolean insert(Category category);
	
	/**
	 * Änderungen in der Db erzwingen, falls das Objekt Detached.
	 * @param category Kategorie-Objekt
	 * @return Kategorie-Objekt
	 */
	public Category update(Category category);
	
	/**
	 * Eine Kategorie in der Db löschen
	 * @param id Id der Kategorie
	 * @return true wenn die Löschung erfolgreich war, andernfalls false
	 */
	public boolean delete(int id);
	
	/**
	 * Prüfen ob die Kategorie in der Db exisitiert
	 * @param id Id der Kategorie
	 * @return true wenn die Kategorie vorhanden ist, andernfalls false
	 */
	public boolean isExists(int id);
}
