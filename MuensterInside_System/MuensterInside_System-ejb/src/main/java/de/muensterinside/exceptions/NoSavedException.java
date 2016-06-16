package de.muensterinside.exceptions;

/**
 *  Exception, wenn Speichern in der Db fehltschlägt
 * @author Lennart Giesen, Julius Wessing
 */
public class NoSavedException extends MuensterInsideException {
	
	private static final int CODE = 10;

	public NoSavedException(String message) {
		super(CODE, message);
	}
}
