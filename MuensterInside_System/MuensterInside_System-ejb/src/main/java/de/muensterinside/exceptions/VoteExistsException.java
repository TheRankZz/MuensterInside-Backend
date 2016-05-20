package de.muensterinside.exceptions;

public class VoteExistsException extends MuensterInsideException {
	private static final int CODE = 40;

	public VoteExistsException(String message) {
		super(CODE, message);
	}

}
