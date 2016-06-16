package de.muensterinside.exceptions;

/**
 * Exception, wenn Vote schon in der Db vorhanden ist
 * @author Lennart Giesen
 */
public class VoteExistsException extends MuensterInsideException {
	private static final int CODE = 40;

	public VoteExistsException(String message) {
		super(CODE, message);
	}

}
