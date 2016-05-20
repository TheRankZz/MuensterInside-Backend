package de.muensterinside.webservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.ws.api.annotation.WebContext;

import de.muensterinside.bl.interfaces.*;
import de.muensterinside.dto.*;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@WebService(name = "mobile")
@WebContext(contextRoot = "/muensterinside")
@Stateless
public class MobileWebserviceImpl implements MobileWebservice {

	@EJB
	private CategoryBLLocal categoryBL;

	@EJB
	private VoteBLLocal voteBL;
	
	@EJB
	private CommentBLLocal commentBL;
	
	@EJB
	private LocationBLLocal locationBL;
	
	@EJB
	private DeviceBLLocal deviceBL;
	
	
	public CategoryListResponse getCategories() {
		return categoryBL.getCategories();
	}

	@Override
	public DeviceResponse register(String deviceId, String username) {
		return deviceBL.register(deviceId, username);
	}

	@Override
	public DeviceResponse login(String deviceId) {
		return deviceBL.login(deviceId);
	}

	@Override
	public LocationListResponse getLocationsByCategory(int cat_id) {
		return locationBL.getLocationsByCategory(cat_id);
	}

	@Override
	public ReturncodeResponse saveLocation(String name, String description,
			String link, int category_id, int deviceId) {
		return locationBL.saveLocation(name, description, link, category_id, deviceId);
		}

	@Override
	public CommentListResponse getCommentsByLocation(int loc_id) {
		return commentBL.getCommentsByLocation(loc_id);
	}

	@Override
	public CommentListResponse getMyComments(int deviceId) {
		return commentBL.getMyComments(deviceId);
	}

	@Override
	public ReturncodeResponse saveComment(String text, int deviceId, int locationId) {
		return commentBL.saveComment(text, deviceId, locationId);
	}

	@Override
	public ReturncodeResponse deleteComment(int comment_id) {
		return commentBL.deleteComment(comment_id);
	}

	@Override
	public LocationListResponse getMyVotes(int deviceId) {
		return voteBL.getMyVotes(deviceId);
	}

	@Override
	public ReturncodeResponse upVote(int location_id, int deviceId) {
		return voteBL.upVote(location_id, deviceId);
	}

	@Override
	public ReturncodeResponse downVote(int location_id, int deviceId) {
		return voteBL.downVote(location_id, deviceId);
	}

	@Override
	public IsVotedRepsonse isVoted(int location_id, int deviceId) {
		return voteBL.isVoted(location_id, deviceId);
	}

	@Override
	public ReturncodeResponse uploadImage(int location_id, String mimeType, String imageDataBase64) {
		return locationBL.uploadImage(location_id, mimeType, imageDataBase64);
	}

	@Override
	public ImageResponse downloadImage(int location_id) {
		return locationBL.downloadImage(location_id);
	}

	@Override
	public LocationResponse getLocation(int id) {
		return locationBL.getLocation(id);
	}

	@Override
	public LocationListResponse getMyLocations(int deviceId) {
		return locationBL.getMyLocations(deviceId);
	}

}
