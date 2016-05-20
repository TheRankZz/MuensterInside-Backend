package de.muensterinside.exceptions;

public class DeviceExistsException extends MuensterInsideException {
		
		private static final int CODE = 30;

		public DeviceExistsException(String message) {
			super(CODE, message);
		}

}
