package de.muensterinside.services;

import javax.ejb.Local;

import de.muensterinside.dto.CategoryListResponse;

@Local
public interface CategoryServiceLocal {

	public CategoryListResponse getCategories();
	
}
