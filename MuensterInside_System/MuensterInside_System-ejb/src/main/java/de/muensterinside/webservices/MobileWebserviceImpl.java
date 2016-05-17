package de.muensterinside.webservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.ws.api.annotation.WebContext;

import de.muensterinside.bl.*;
import de.muensterinside.dto.*;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@WebService(name="mobile")
@WebContext(contextRoot="/muensterinside")
@Stateless
public class MobileWebserviceImpl implements MobileWebservice {

	@EJB
	private CategoryBL categoryBL;
	
	@EJB
	private CommentBL commentBL;
	
	@EJB
	private LocationBL locationBL;
	

	
	public CategoryListResponse getCategories() {
		return categoryBL.getCategories();
	}


	@Override
	public ReturncodeResponse register(String deviceId, String username) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ReturncodeResponse login(String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public LocationListResponse getLocationsByCategory(int cat_id) {
		return locationBL.getLocationsByCategory(cat_id);
	}



	@Override
	public ReturncodeResponse saveLocation(String name, String description, String link, int voteValue,  int deviceId, int categoryId) {
		return locationBL.saveLocation(name, description, link, voteValue, deviceId, categoryId);
	}



	@Override
	public CommentListResponse getCommentsByLocation(int loc_id) {
		return commentBL.getCommentsByLocation(loc_id);
	}



	@Override
	public CommentListResponse getMyComments(String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ReturncodeResponse saveComment(String text, String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ReturncodeResponse deleteComment(int comment_id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public LocationListResponse getMyVotes(String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ReturncodeResponse upVote(int location_id, String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ReturncodeResponse downVote(int location_id, String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public IsVotedRepsonse isVoted(int location_id, String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
