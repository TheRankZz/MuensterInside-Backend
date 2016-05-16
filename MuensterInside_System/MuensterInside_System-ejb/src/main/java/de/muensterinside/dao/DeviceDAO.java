package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.muensterinside.entities.Device;

@Stateless
public class DeviceDAO implements de.muensterinside.dao.interfaces.DeviceDAOLocal{

	@PersistenceContext
	private EntityManager em;	
	
	@Override
	public Device findByID(int id) {
		return em.find(Device.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Device> findAll() {
		List<Device> resultList = em.createQuery("SELECT * FROM devices").getResultList();
		return resultList;
	}

	@Override
	public boolean insert(Device device) {
		boolean result = false;
		em.persist(device);
		
		if(device.getId() != 0)
			result = true;
		
		return result;
	}

	@Override
	public Device update(Device device) {
		return em.merge(device);
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		Device device = em.find(Device.class, id);
		em.remove(device);
		
		if(em.find(Device.class, id) == null) 
			result = true;
		
		return result;	
	}
	
	@Override
	public boolean isExists(int deviceId) {
		boolean result = false;
		Device device = em.find(Device.class, deviceId);
		if(device == null) 
			result = true;
		
		return result;	
	}
	
}
