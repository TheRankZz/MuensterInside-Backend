package de.muensterinside.exceptions;

public class NoSavedException extends MuensterInsideException {
	
	private static final int CODE = 201;

	public NoSavedException(String message) {
		super(CODE, message);
	}
}
