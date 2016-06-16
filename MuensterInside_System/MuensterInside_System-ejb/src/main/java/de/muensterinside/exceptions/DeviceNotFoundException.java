package de.muensterinside.exceptions;

/**
 * Exception, wenn Device in der DB nicht gefunden wurde.
 * @author Lennart Giesen
 */
public class DeviceNotFoundException extends MuensterInsideException {

	private static final int CODE = 31;

	public DeviceNotFoundException(String message) {
		super(CODE, message);
	}
}
