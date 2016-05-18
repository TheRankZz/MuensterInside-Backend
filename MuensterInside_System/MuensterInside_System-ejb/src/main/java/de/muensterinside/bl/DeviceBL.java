package de.muensterinside.bl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.muensterinside.bl.interfaces.DeviceBLLocal;
import de.muensterinside.dao.interfaces.DeviceDAOLocal;
import de.muensterinside.dto.DeviceResponse;
import de.muensterinside.dto.ReturncodeResponse;
import de.muensterinside.entities.Device;
import de.muensterinside.util.DtoAssembler;

@Stateless
public class DeviceBL implements DeviceBLLocal {

	@EJB
	DeviceDAOLocal daoDevice;
	
	@EJB
	DtoAssembler dtoAssembler;

	@Override
	public DeviceResponse register(String deviceId, String username) {
		DeviceResponse response = new DeviceResponse();

		if (daoDevice.findByDeviceId(deviceId) != null) {
			response.setReturnCode(222);
			response.setMessage("Gerät wurde bereits registriert!");
		} else {
			Device dev = new Device(deviceId, username);
			daoDevice.insert(dev);
			response.setMessage("Gerät wurde erfolgreich registriert!");
		}

		return response;
	}

	@Override
	public DeviceResponse login(String deviceId) {
		DeviceResponse response = new DeviceResponse();
		Device dev = daoDevice.findByDeviceId(deviceId);

		if (dev != null) {
			dev.setLastLoginAt();
			daoDevice.update(dev);
			response.setMessage("Wilkommen zurück " + dev.getUsername() + "!");
			response.setDevice(dtoAssembler.makeDTO(dev));
		} else {
			response.setReturnCode(222);
			response.setMessage("Bitte vorher das Gerät registrieren!");
		}

		return response;
	}

}
