package de.muensterinside.dao;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Device;

@Local
public interface DeviceDAOLocal {

	public Device findByID(int id);

	public Device findByAndroidUuid(String uuid);

	public List<Device> findAll();

	public boolean insert(Device device);

	public Device update(Device device);

	public boolean delete(int id);

	public boolean isExists(int deviceId);
}
