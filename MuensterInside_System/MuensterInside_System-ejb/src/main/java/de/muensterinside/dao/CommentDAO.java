package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.muensterinside.entities.Comment;
import de.muensterinside.entities.Location;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Stateless
public class CommentDAO implements de.muensterinside.dao.interfaces.CommentDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Comment findByID(int id) {
		return em.find(Comment.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAll() {
		List<Comment> resultList = (List<Comment>) em.createQuery("SELECT c FROM Comment c")
				.getResultList();
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findByLocation(int loc_id) {
		List<Comment> list = em.createQuery("SELECT c FROM comments c WHERE c.location_id = :locationID")
				.setParameter("LocationID", loc_id)
				.getResultList();
		return list;
	}

	@Override
	public boolean insert(Comment comment) {
		boolean result = false;
		em.persist(comment);
		
		if(comment.getId() != 0)
			result = true;
		
		return result;
	}

	@Override
	public Comment update(Comment comment) {
		return em.merge(comment);
	}

	@Override
	public boolean delete(int comment_id) {
		boolean result = false;
		Comment cat = em.find(Comment.class, comment_id);
		em.remove(cat);
		
		if(em.find(Comment.class, comment_id) == null) 
			result = true;
		
		return result;	
	}

}
