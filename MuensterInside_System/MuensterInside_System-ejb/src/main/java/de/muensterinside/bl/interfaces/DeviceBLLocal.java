package de.muensterinside.bl.interfaces;

import javax.ejb.Local;

import de.muensterinside.dto.DeviceResponse;

@Local
public interface DeviceBLLocal {

	public DeviceResponse register(String deviceId, String username);

	public DeviceResponse login(String deviceId);

}
