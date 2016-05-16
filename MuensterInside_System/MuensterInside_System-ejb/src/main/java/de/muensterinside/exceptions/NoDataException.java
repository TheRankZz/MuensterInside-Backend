package de.muensterinside.exceptions;

public class NoDataException extends MuensterInsideException {
	
	private static final int CODE = 301;

	public NoDataException(String message) {
		super(CODE, message);
	}

}
