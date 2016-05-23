package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.muensterinside.entities.Category;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Stateless
public class CategoryDAO implements de.muensterinside.dao.CategoryDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Category findByID(int id) {
		return em.find(Category.class, id);
	}

	@Override
	public List<Category> findAll() {
		@SuppressWarnings("unchecked")
		List<Category> resultList = (List<Category>) em.createQuery("SELECT c FROM Category c")
				.getResultList();
		return resultList;
		
	}

	@Override
	public boolean insert(Category category) {
		boolean result = false;
		em.persist(category);
		
		if(category.getId() != 0)
			result = true;
		
		return result;
	}

	@Override
	public Category update(Category category) {
		return em.merge(category);
	}

	@Override
	public boolean delete(int category_id) {
		boolean result = false;
		Category cat = em.find(Category.class, category_id);
		em.remove(cat);
		
		if(em.find(Category.class, category_id) == null) 
			result = true;
		
		return result;		
	}

	@Override
	public boolean isExists(int id) {
		boolean result = false;
		Category category = em.find(Category.class, id);
		if(category != null) 
			result = true;
		
		return result;	
	}

}
