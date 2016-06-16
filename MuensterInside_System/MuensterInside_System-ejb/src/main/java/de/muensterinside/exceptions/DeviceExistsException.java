package de.muensterinside.exceptions;

/**
 * Exception, wenn das Device schon in der DB vorhanden ist.
 * @author Lennart Giesen
 */
public class DeviceExistsException extends MuensterInsideException {
		
		private static final int CODE = 30;

		public DeviceExistsException(String message) {
			super(CODE, message);
		}

}
