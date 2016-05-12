package de.muensterinside.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Category;

@Local
public interface CategoryDAO {

	public Category findByID(int id);
	
	public List<Category> findAll();
	
	public boolean insert(Category category);
	
	public Category update(Category category);
	
	public boolean delete(int category_id);
}
