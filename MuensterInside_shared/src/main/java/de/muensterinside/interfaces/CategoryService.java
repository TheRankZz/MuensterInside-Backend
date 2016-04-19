package de.muensterinside.interfaces;

public interface CategoryService {

	public Category getCategory(int cat_id);
	
	public List<Catergory> getCategories();
	
	public boolean addCategory(Category cat);
	
	public boolean removeCategory(int cat_id);
	
}
