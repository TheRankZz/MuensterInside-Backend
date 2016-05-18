package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.muensterinside.bl.interfaces.CategoryBLLocal;
import de.muensterinside.dao.interfaces.CategoryDAOLocal;
import de.muensterinside.dto.CategoryListResponse;
import de.muensterinside.entities.Category;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */

@Stateless
public class CategoryBL implements CategoryBLLocal {

	@EJB
	private CategoryDAOLocal daoCategory;

	@EJB
	private DtoAssembler dtoAssembler;

	/**
	 * Holt eine Liste von allen Kategorien
	 * 
	 * @return
	 */
	public CategoryListResponse getCategories() {
		CategoryListResponse response = new CategoryListResponse();

		try {
			List<Category> categories = daoCategory.findAll();

			if (categories.isEmpty()) {
				throw new NoDataException(Messages.NoDataExceptionMsg);
			}

			response.setCategoryList(dtoAssembler.makeDTOCategoryList(categories));

		} catch (MuensterInsideException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}
		return response;
	}

}
