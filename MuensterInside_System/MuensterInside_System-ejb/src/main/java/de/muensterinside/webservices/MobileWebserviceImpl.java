package de.muensterinside.webservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.muensterinside.dto.*;
import de.muensterinside.services.CategoryServiceLocal;
import de.muensterinside.services.CommentServiceLocal;
import de.muensterinside.services.DeviceServiceLocal;
import de.muensterinside.services.LocationBLLocal;
import de.muensterinside.services.VoteServiceLocal;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@WebService(name = "mobile")
@WebContext(contextRoot = "/muensterinside")
@Stateless
public class MobileWebserviceImpl implements MobileWebservice {

	private static final Logger logger = Logger.getLogger(MobileWebserviceImpl.class);

	@EJB
	private CategoryServiceLocal categoryBL;

	@EJB
	private VoteServiceLocal voteBL;

	@EJB
	private CommentServiceLocal commentBL;

	@EJB
	private LocationBLLocal locationBL;

	@EJB
	private DeviceServiceLocal deviceBL;

	public CategoryListResponse getCategories() {
		logger.info("Methodenaufruf: getCategories()");
		return categoryBL.getCategories();
	}

	@Override
	public DeviceResponse register(String androidUuid, String username) {
		logger.info("Methodenaufruf: register(" + androidUuid + "," + username + ")");
		return deviceBL.register(androidUuid, username);
	}

	@Override
	public DeviceResponse login(String androidUuid) {
		logger.info("Methodenaufruf: login(" + androidUuid + ")");
		return deviceBL.login(androidUuid);
	}

	@Override
	public LocationListResponse getLocationsByCategory(int cat_id) {
		logger.info("Methodenaufruf: getLocationsByCategory(" + cat_id + ")");
		return locationBL.getLocationsByCategory(cat_id);
	}

	@Override
	public ReturncodeResponse saveLocation(String name, String description, String link, int category_id,
			int deviceId) {
		logger.info("Methodenaufruf: saveLocation(" + name + "," + description + "," + link + "," + category_id + ","
				+ deviceId + ")");
		return locationBL.saveLocation(name, description, link, category_id, deviceId);
	}

	@Override
	public CommentListResponse getCommentsByLocation(int loc_id) {
		logger.info("Methodenaufruf: getCommentsByLocation(" + loc_id + ")");
		return commentBL.getCommentsByLocation(loc_id);
	}

	@Override
	public CommentListResponse getMyComments(int deviceId) {
		logger.info("Methodenaufruf: getMyComments(" + deviceId + ")");
		return commentBL.getMyComments(deviceId);
	}

	@Override
	public ReturncodeResponse saveComment(String text, int deviceId, int locationId) {
		logger.info("Methodenaufruf: saveComment(" + text + "," + deviceId + "," + locationId + ")");
		return commentBL.saveComment(text, deviceId, locationId);
	}

	@Override
	public ReturncodeResponse deleteComment(int comment_id) {
		logger.info("Methodenaufruf: deleteComment(" + comment_id + ")");
		return commentBL.deleteComment(comment_id);
	}

	@Override
	public LocationListResponse getMyVotes(int deviceId) {
		logger.info("Methodenaufruf: getMyVotes(" + deviceId + ")");
		return voteBL.getMyVotes(deviceId);
	}

	@Override
	public ReturncodeResponse upVote(int location_id, int deviceId) {
		logger.info("Methodenaufruf: upVote(" + location_id + "," + deviceId + ")");
		return voteBL.upVote(location_id, deviceId);
	}

	@Override
	public ReturncodeResponse downVote(int location_id, int deviceId) {
		logger.info("Methodenaufruf: downVote(" + location_id + "," + deviceId + ")");
		return voteBL.downVote(location_id, deviceId);
	}

	@Override
	public IsVotedRepsonse isVoted(int location_id, int deviceId) {
		logger.info("Methodenaufruf: isVoted(" + location_id + "," + deviceId + ")");
		return voteBL.isVoted(location_id, deviceId);
	}

	@Override
	public ReturncodeResponse uploadImage(int location_id, String mimeType, String imageDataBase64) {
		logger.info("Methodenaufruf: uploadImage(" + location_id + "," + mimeType + ",content)");
		return locationBL.uploadImage(location_id, mimeType, imageDataBase64);
	}

	@Override
	public ImageResponse downloadImage(int location_id) {
		logger.info("Methodenaufruf: downloadImage(" + location_id + ")");
		return locationBL.downloadImage(location_id);
	}

	@Override
	public LocationResponse getLocation(int id) {
		logger.info("Methodenaufruf: getLocation(" + id + ")");
		return locationBL.getLocation(id);
	}

	@Override
	public LocationListResponse getMyLocations(int deviceId) {
		logger.info("Methodenaufruf: getMyLocations(" + deviceId + ")");
		return locationBL.getMyLocations(deviceId);
	}

}
