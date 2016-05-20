package de.muensterinside.exceptions;

public class NoDataException extends MuensterInsideException {
	
	private static final int CODE = 20;

	public NoDataException(String message) {
		super(CODE, message);
	}

}
