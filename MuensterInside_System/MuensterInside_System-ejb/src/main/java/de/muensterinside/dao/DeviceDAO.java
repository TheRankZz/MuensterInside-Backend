package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.muensterinside.entities.Device;

/**
 * @author Lennart Giesen, Julius Wessing
 */
@Stateless
public class DeviceDAO implements de.muensterinside.dao.DeviceDAOLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Device findByID(int id) {
		return em.find(Device.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Device> findAll() {
		List<Device> resultList = em.createQuery("SELECT d FROM Device d").getResultList();
		return resultList;
	}

	@Override
	public boolean insert(Device device) {
		boolean result = false;
		em.persist(device);

		if (device.getId() != 0)
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
		if(device != null) {
			em.remove(device);
	
			if (em.find(Device.class, id) == null)
				result = true;
		}
		
		return result;
	}

	@Override
	public Device findByAndroidUuid(String uuid) {
		@SuppressWarnings("rawtypes")
		List results = em.createQuery("SELECT d FROM Device d WHERE d.androidUuid LIKE :uuid")
				.setParameter("uuid", uuid).getResultList();

		if (results.size() == 1) {
			return (Device) results.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean isExists(int deviceId) {
		boolean result = false;
		Device device = findByID(deviceId);
		if (device != null)
			result = true;

		return result;
	}

}
