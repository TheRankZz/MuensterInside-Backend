package de.muensterinside.dto;

import java.util.List;

/**
 * @author Lennart Giesen
 */
public class CommentListResponse extends ReturncodeResponse {
	
	private List<CommentTO> commentList;

	public List<CommentTO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentTO> commentList) {
		this.commentList = commentList;
	}

}
