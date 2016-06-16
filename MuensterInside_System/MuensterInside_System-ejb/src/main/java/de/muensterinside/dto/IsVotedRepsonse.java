package de.muensterinside.dto;

/**
 * @author Lennart Giesen
 */
public class IsVotedRepsonse extends ReturncodeResponse {

	private boolean IsVoted;

	public boolean isIsVoted() {
		return IsVoted;
	}

	public void setIsVoted(boolean isVoted) {
		IsVoted = isVoted;
	}
	
}
