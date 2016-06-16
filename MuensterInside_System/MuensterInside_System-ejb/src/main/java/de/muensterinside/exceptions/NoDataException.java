package de.muensterinside.exceptions;

/**
 * Exception, wenn Daten in der DB nicht gefunden wurde
 * @author Lennart Giesen
 */
public class NoDataException extends MuensterInsideException {
	
	private static final int CODE = 20;

	public NoDataException(String message) {
		super(CODE, message);
	}

}
