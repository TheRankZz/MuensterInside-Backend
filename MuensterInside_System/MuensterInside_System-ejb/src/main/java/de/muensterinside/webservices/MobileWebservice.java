package de.muensterinside.webservices;

import de.muensterinside.dto.*;

/**
 * Interface: Webservice für Mobile-Clients
 * @author Lennart Giesen, Julius Wessing
 *
 */
public interface MobileWebservice {

	//EJB für Login/Register
	public ReturncodeResponse register(String deviceId, String username);
	
	public ReturncodeResponse login(String deviceId);
	
	//EJB für Category
	public CategoryListResponse getCategories();
	
	//EJB für Location
	public LocationListResponse getLocationsByCategory(int cat_id);
	
	public ReturncodeResponse saveLocation(String name, String description, 
			String link, String deviceId);

	//EJB für Comment
	public CommentListResponse getCommentsByLocation(int loc_id);
	
	public CommentListResponse getMyComments(String deviceId);
	
	public ReturncodeResponse saveComment(String text, String deviceId);
	
	public ReturncodeResponse deleteComment(int comment_id);
	

	//EJB für Vote
	public LocationListResponse getMyVotes(String deviceId);
	
	public ReturncodeResponse upVote(int location_id, String deviceId);
	
	public ReturncodeResponse downVote(int location_id, String deviceId);	
	
	public IsVotedRepsonse isVoted(int location_id, String deviceId);
	
}
