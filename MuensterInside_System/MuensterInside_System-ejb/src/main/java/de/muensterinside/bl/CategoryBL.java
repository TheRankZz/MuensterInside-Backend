package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import de.muensterinside.dao.CategoryDAO;
import de.muensterinside.dto.CategoryListResponse;
import de.muensterinside.entities.Category;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;
import de.muensterinside.util.DtoAssembler;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Local
@Stateless
public class CategoryBL {
	
	@EJB
	private CategoryDAO daoCategory;
	
	@EJB
	private DtoAssembler dtoAssembler;

	/**
	 * Holt eine Liste von allen Kategorien
	 * @return
	 */
	public CategoryListResponse getCategories() {
		CategoryListResponse response = new CategoryListResponse();
		
		try {
			List<Category> categories = daoCategory.findAll();
	
			if(categories.isEmpty()) {
				throw new NoDataException("Es wurden keine Kategorien gefunden");
			}
			
			response.setCategoryList(dtoAssembler.makeDTOCategoryList(categories));
			
		} catch (MuensterInsideException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}
		return response;	
	}
	
	
}
