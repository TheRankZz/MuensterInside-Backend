package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.muensterinside.entities.Location;

/**
 * @author Lennart Giesen, Julius Wessing
 */
@Stateless
public class LocationDAO implements de.muensterinside.dao.LocationDAOLocal {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> findAll() {
		Query query = em.createQuery("SELECT l FROM Location l");
		return (List<Location>) query.getResultList();
	}

	@Override
	public Location findById(int id) {
		return em.find(Location.class, id);
	}
	
	@Override
	public List<Location> findByCategory(int cat_id) {
		@SuppressWarnings("unchecked")
		List<Location> list = em.createQuery("SELECT l FROM Location l WHERE l.category.id = :categoryId")
				.setParameter("categoryId", cat_id)
				.getResultList();
		
		return list;
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
		if(loc == null) {
			em.remove(loc);
	
			if (findById(location_id) == null)
				result = true;
		}
		
		return result;
	}
	
	@Override
	public boolean isExists(int locationId) {
		boolean result = false;
		Location location = findById(locationId);
		if(location != null) 
			result = true;
		
		return result;	
	}

	@Override
	public List<Location> findByDevice(int deviceId) {
		@SuppressWarnings("unchecked")
		List<Location> list = em.createQuery("SELECT l FROM Location l WHERE l.device.id = :deviceId")
				.setParameter("deviceId", deviceId)
				.getResultList();
		
		return list;
	}
	
	
	public List<Location> findByMyVotes(int deviceId) {
		@SuppressWarnings("unchecked")
		List<Location> list = em.createQuery("SELECT l FROM Location l "
				+ "JOIN l.votes v ON v.location.id = l.id "
				+ "WHERE v.device.id = :deviceId")
				.setParameter("deviceId", deviceId)
				.getResultList();
		
		return list;
	}

}
