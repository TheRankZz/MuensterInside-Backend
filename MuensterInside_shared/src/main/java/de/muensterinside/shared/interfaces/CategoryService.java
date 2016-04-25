package de.muensterinside.shared.interfaces;

import java.util.List;

import de.muensterinside.shared.entities.Category;

/**
 * Dieses Business Interface ist zuständig für die Kategorien.
 * @author Lennart Giesen, Julius Wessing
 *
 */
public interface CategoryService {

	/**
	 * Gibt eine Kategorie anhand der ID zurück.
	 * @param cat_id 
	 * @return
	 */
	public Category getCategory(int cat_id);
	
	/**
	 * Gibt alle Kategorien zurück.
	 * @return
	 */
	public List<Category> getCategories();
	
	/**
	 * Neue Kategorie hinzufügen.
	 * @param cat
	 * @return 
	 */
	public boolean addCategory(Category cat);
	
	/**
	 * Kategorie anhand der Id löschen.
	 * @param cat_id
	 * @return 
	 */
	public boolean removeCategory(int cat_id);
	
}
