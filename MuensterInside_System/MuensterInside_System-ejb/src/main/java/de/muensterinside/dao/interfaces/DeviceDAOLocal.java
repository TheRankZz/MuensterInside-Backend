package de.muensterinside.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Device;

@Local
public interface DeviceDAOLocal {

	public Device findByID(int id);

	public Device findByDeviceId(String deviceId);

	public List<Device> findAll();

	public boolean insert(Device device);

	public Device update(Device device);

	public boolean delete(int id);

	public boolean isExists(String deviceId);
}
