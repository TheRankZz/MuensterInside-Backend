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
public class CategoryDAO implements de.muensterinside.dao.interfaces.CategoryDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Category findByID(int id) {
		return em.find(Category.class, id);
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>) em.createQuery("SELECT * FROM Categories").getResultList();
		
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

}