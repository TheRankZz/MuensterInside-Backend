package de.muensterinside.services;

import javax.ejb.Local;

import de.muensterinside.dto.CommentListResponse;
import de.muensterinside.dto.ReturncodeResponse;

@Local
public interface CommentServiceLocal {

	public CommentListResponse getCommentsByLocation(int loc_id);

	public CommentListResponse getMyComments(int deviceId);

	public ReturncodeResponse saveComment(String text, int deviceId, int locationId);

	public ReturncodeResponse deleteComment(int comment_id);
}
