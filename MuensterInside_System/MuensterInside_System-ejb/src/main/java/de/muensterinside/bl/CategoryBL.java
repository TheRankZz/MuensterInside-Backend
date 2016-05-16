package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import de.muensterinside.dao.CategoryDAO;
import de.muensterinside.dto.CategoryListResponse;
import de.muensterinside.entities.Category;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.util.DtoAssembler;

@Local
@Stateless
public class CategoryBL {
	
	@EJB
	private CategoryDAO daoCategory;
	
	@EJB
	private DtoAssembler dtoAssembler;

	/**
	 * 
	 * @return
	 */
	public CategoryListResponse getCategories() {
		CategoryListResponse response = new CategoryListResponse();
		
		try {
			List<Category> categories = daoCategory.findAll();
			
			
		} catch (MuensterInsideException ex) {
			
		}
		
		return response;	
	}
	
	
}
