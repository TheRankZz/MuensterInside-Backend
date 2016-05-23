package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Category;

@Local
public interface CategoryDAOLocal {

	public Category findByID(int id);
	
	public List<Category> findAll();
	
	public boolean insert(Category category);
	
	public Category update(Category category);
	
	public boolean delete(int id);
	
	public boolean isExists(int id);
}
