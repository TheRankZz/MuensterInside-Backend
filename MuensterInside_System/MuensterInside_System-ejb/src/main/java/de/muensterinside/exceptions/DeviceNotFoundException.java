package de.muensterinside.exceptions;

public class DeviceNotFoundException extends MuensterInsideException {

	private static final int CODE = 31;

	public DeviceNotFoundException(String message) {
		super(CODE, message);
	}
}
