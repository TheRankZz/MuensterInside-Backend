package de.muensterinside.services;

import java.util.List;


import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.muensterinside.dao.CommentDAOLocal;
import de.muensterinside.dao.DeviceDAOLocal;
import de.muensterinside.dao.LocationDAOLocal;
import de.muensterinside.dto.CommentListResponse;
import de.muensterinside.dto.ReturncodeResponse;
import de.muensterinside.entities.Comment;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;
import de.muensterinside.exceptions.NoSavedException;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;


//TODO: Klasse kommentieren

@Stateless
public class CommentService implements CommentServiceLocal {

	@EJB
	CommentDAOLocal commentDAO;

	@EJB
	DeviceDAOLocal deviceDAO;

	@EJB
	LocationDAOLocal locationDAO;

	@EJB
	private DtoAssembler dtoAssembler;

	@Override
	public CommentListResponse getCommentsByLocation(int loc_id) {
		CommentListResponse response = new CommentListResponse();

		try {
			List<Comment> comments = commentDAO.findByLocation(loc_id);

			if (comments.isEmpty()) {
				throw new NoDataException(Messages.NoDataExceptionMsg);
			}

			response.setCommentList(dtoAssembler.makeDTOCommentList(comments));
		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	@Override
	public CommentListResponse getMyComments(int deviceId) {
		CommentListResponse response = new CommentListResponse();

		try {
			List<Comment> comments = commentDAO.findByDevice(deviceId);

			if (comments.isEmpty()) {
				throw new NoDataException(Messages.NoDataExceptionMsg);
			}

			response.setCommentList(dtoAssembler.makeDTOCommentList(comments));
		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	@Override
	public ReturncodeResponse saveComment(String text, int deviceId, int locationId) {
		ReturncodeResponse response = new ReturncodeResponse();

		try {
			if (!deviceDAO.isExists(deviceId))
				throw new NoDataException(Messages.NoFoundExceptionMsg);
			if (!locationDAO.isExists(locationId))
				throw new NoDataException(Messages.NoFoundExceptionMsg);

			Device device = deviceDAO.findByID(deviceId);
			Location location = locationDAO.findById(locationId);

			Comment comment = new Comment(text, device, location);

			if (!commentDAO.insert(comment))
				throw new NoSavedException(Messages.NoSavedExceptionMsg);

		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	@Override
	public ReturncodeResponse deleteComment(int comment_id) {
		ReturncodeResponse response = new ReturncodeResponse();

		try {
			if (!commentDAO.delete(comment_id))
				throw new NoSavedException(Messages.NoDeleteExceptionMsg);
		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}
}