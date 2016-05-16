package de.muensterinside.bl.interfaces;

import javax.ejb.Local;

import de.muensterinside.dto.ReturncodeResponse;

@Local
public interface DeviceBLLocal {

	public ReturncodeResponse register(String deviceId, String username);

	public ReturncodeResponse login(String deviceId);

}
