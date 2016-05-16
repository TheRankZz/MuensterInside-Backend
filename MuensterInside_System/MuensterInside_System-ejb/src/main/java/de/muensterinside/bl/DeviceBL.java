package de.muensterinside.bl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.muensterinside.bl.interfaces.DeviceBLLocal;
import de.muensterinside.dao.interfaces.DeviceDAOLocal;
import de.muensterinside.dto.ReturncodeResponse;
import de.muensterinside.entities.Device;

@Stateless
public class DeviceBL implements DeviceBLLocal {

	@EJB
	DeviceDAOLocal daoDevice;

	@Override
	public ReturncodeResponse register(String deviceId, String username) {
		ReturncodeResponse response = new ReturncodeResponse();

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
	public ReturncodeResponse login(String deviceId) {
		ReturncodeResponse response = new ReturncodeResponse();
		Device dev = daoDevice.findByDeviceId(deviceId);

		if (dev != null) {
			dev.setLastLoginAt();
			daoDevice.update(dev);
			response.setMessage("Wilkommen zurück " + dev.getUsername() + "!");
		} else {
			response.setReturnCode(222);
			response.setMessage("Bitte vorher das Gerät registrieren!");
		}

		return response;
	}

}
