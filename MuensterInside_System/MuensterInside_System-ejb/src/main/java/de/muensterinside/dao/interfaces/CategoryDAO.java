package de.muensterinside.dao.interfaces;

import java.util.List;

import de.muensterinside.entities.Category;

public interface CategoryDAO {

	public Category findByID(int id);
	
	public List<Category> findAll();
	
	public boolean insert();
	
	public boolean update();
	
	public boolean delete();
}
