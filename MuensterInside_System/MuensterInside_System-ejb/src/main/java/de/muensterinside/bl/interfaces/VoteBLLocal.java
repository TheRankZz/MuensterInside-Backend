package de.muensterinside.bl.interfaces;

import javax.ejb.Local;

import de.muensterinside.dto.IsVotedRepsonse;
import de.muensterinside.dto.LocationListResponse;
import de.muensterinside.dto.ReturncodeResponse;

@Local
public interface VoteBLLocal {

public LocationListResponse getMyVotes(int deviceId);
	
	public ReturncodeResponse upVote(int location_id, int deviceId);
	
	public ReturncodeResponse downVote(int location_id, int deviceId);	
	
	public IsVotedRepsonse isVoted(int location_id, int deviceId);
}
