package de.muensterinside.bl.interfaces;

import javax.ejb.Local;

import de.muensterinside.dto.CommentListResponse;
import de.muensterinside.dto.ReturncodeResponse;

@Local
public interface CommentBLLocal {

	public CommentListResponse getCommentsByLocation(int loc_id);

	public CommentListResponse getMyComments(String deviceId);

	public ReturncodeResponse saveComment(String text, String deviceId);

	public ReturncodeResponse deleteComment(int comment_id);
}
