package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import de.muensterinside.dao.CategoryDAO;
import de.muensterinside.dto.CategoryListResponse;
import de.muensterinside.entities.Category;
import de.muensterinside.util.DtoAssembler;

@Local
@Stateless
public class CategoryBL {
	
	@EJB
	private CategoryDAO categoryDAO;
	
	@EJB
	private DtoAssembler dtoAssembler;

	public CategoryListResponse getCategories() {
		CategoryListResponse response = new CategoryListResponse();
		
		List<Category> categoryList = categoryDAO.findAll();
		
		response.setCategoryList(dtoAssembler.makeDTO(categoryList));
		
		return response;	
	}
}
