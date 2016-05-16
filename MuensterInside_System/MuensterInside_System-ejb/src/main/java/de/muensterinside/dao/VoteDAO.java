package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.muensterinside.entities.Vote;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Stateless
public class VoteDAO implements de.muensterinside.dao.interfaces.VoteDAOLocal {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Vote> findAll() {
		Query query = em.createQuery("SELECT v FROM votes v");
		return (List<Vote>) query.getResultList();
	}

	@Override
	public Vote findById(int id) {
		return em.find(Vote.class, id);
	}

	@Override
	public boolean insert(Vote vote) {
		boolean result = false;

		em.persist(vote);

		if (vote.getId() != 0)
			result = true;

		return result;
	}

	@Override
	public Vote update(Vote vote) {
		return em.merge(vote);
	}

	@Override
	public boolean delete(int vote_id) {
		boolean result = false;

		Vote vote = findById(vote_id);
		em.remove(vote);

		if (findById(vote_id) == null)
			result = true;

		return result;
	}

}
