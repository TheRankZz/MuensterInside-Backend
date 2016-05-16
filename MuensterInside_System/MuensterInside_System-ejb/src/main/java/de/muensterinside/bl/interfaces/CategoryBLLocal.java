package de.muensterinside.bl.interfaces;

import javax.ejb.Local;

import de.muensterinside.dto.CategoryListResponse;

@Local
public interface CategoryBLLocal {

	public CategoryListResponse getCategories();
	
}
