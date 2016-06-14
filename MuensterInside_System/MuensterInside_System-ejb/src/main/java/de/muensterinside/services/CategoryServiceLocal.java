package de.muensterinside.services;

import javax.ejb.Local;

import de.muensterinside.dto.CategoryListResponse;

/**
 * Diese Bean stellt die Operation für Kategorien bereit.
 * @author Lennart Giesen, Julius Wessing
 */
@Local
public interface CategoryServiceLocal {

	/**
	 * Gibt eine Liste von Kategorien zurück.
	 * @return Liste von Kategorien im Response
	 */
	public CategoryListResponse getCategories();
	
}
