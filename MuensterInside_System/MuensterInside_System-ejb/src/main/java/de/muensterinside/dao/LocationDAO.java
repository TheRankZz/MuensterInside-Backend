package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.muensterinside.entities.Location;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Stateless
public class LocationDAO implements de.muensterinside.dao.interfaces.LocationDAOLocal {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> findAll() {
		Query query = em.createQuery("SELECT l FROM locations l");
		return (List<Location>) query.getResultList();
	}

	@Override
	public Location findById(int id) {
		return em.find(Location.class, id);
	}

	@Override
	public boolean insert(Location loc) {
		boolean result = false;
		em.persist(loc);

		if (loc.getId() != 0)
			result = true;

		return result;
	}

	@Override
	public Location update(Location loc) {
		return em.merge(loc);
	}

	@Override
	public boolean delete(int location_id) {
		boolean result = false;
		Location loc = findById(location_id);
		em.remove(loc);

		if (findById(location_id) == null)
			result = true;

		return result;
	}

}
