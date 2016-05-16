package de.muensterinside.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Category;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;

@Local
public interface CategoryDAOLocal {

	public Category findByID(int id) throws NoDataException;
	
	public List<Category> findAll() throws NoDataException;
	
	public boolean insert(Category category);
	
	public Category update(Category category);
	
	public boolean delete(int category_id);
}
