package de.muensterinside.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import de.muensterinside.dao.CategoryDAOLocal;
import de.muensterinside.dto.CategoryListResponse;
import de.muensterinside.entities.Category;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;
import de.muensterinside.util.OutputRequesterBean;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
//TODO: Klasse kommentieren

@Stateless
public class CategoryService implements CategoryServiceLocal {
	
	private static final Logger logger = Logger.getLogger(CategoryService.class);

	@EJB
	private CategoryDAOLocal daoCategory;

	@EJB
	private DtoAssembler dtoAssembler;
	
	@EJB
	private OutputRequesterBean outputRequester;

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
			//TODO: Nur für Testzwecke eingebaut, muss wieder entfernt werden.
			outputRequester.printLog("Dies ist der erste Test log!");
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
