package de.muensterinside.dto;

import java.util.List;

public class VoteListResponse extends ReturncodeResponse {
	
	private List<VoteTO> voteList;

	public List<VoteTO> getVoteList() {
		return voteList;
	}

	public void setVoteList(List<VoteTO> voteList) {
		this.voteList = voteList;
	}
	

}
