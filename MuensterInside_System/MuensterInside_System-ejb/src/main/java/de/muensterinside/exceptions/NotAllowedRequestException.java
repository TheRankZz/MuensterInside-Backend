package de.muensterinside.exceptions;

/**
 * Exeption bei ungültiger Anfrage
 * @author Lennart Giesen
 */
public class NotAllowedRequestException extends MuensterInsideException {

	private static final int CODE = 50;

	public NotAllowedRequestException(String message) {
		super(CODE, message);
	}
}
