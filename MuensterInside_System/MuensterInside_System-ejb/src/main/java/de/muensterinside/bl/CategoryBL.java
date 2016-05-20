package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

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
//TODO: Klasse kommentieren

@Stateless
public class CategoryBL implements CategoryBLLocal {
	
	private static final Logger logger = Logger.getLogger(CategoryBL.class);

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
			logger.info("Eine Liste von Kategorien wird zurückgegeben");
		} catch (MuensterInsideException e) {
			logger.error("Fehler " + e.getErrorCode() + ": " + e.getMessage());
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.fatal("Unbekannter Fehler " + Messages.SystemErrorCode + ":" + e.getMessage());
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}
		return response;
	}

}
