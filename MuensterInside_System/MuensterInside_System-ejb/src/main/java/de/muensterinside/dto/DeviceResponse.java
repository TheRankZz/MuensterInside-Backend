package de.muensterinside.dto;


public class DeviceResponse extends ReturncodeResponse {
	
	private DeviceTO device;
	

	public DeviceTO getDevice() {
		return device;
	}

	public void setDevice(DeviceTO device) {
		this.device = device;
	}
}
