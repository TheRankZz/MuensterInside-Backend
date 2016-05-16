package de.muensterinside.dao.interfaces;

import java.util.List;

import de.muensterinside.entities.Device;

public interface DeviceDAO {

	public Device findByID(int id);
	
	public List<Device> findAll();
	
	public boolean insert(Device device);
	
	public Device update(Device device);
	
	public boolean delete(int id);
	
	public boolean isExists(int deviceId);
}
