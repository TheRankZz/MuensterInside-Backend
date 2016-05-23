package de.muensterinside.services;

import javax.ejb.Local;

import de.muensterinside.dto.DeviceResponse;

@Local
public interface DeviceServiceLocal {

	public DeviceResponse register(String deviceId, String username);

	public DeviceResponse login(String deviceId);

}
