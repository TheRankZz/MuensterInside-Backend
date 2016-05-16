package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.muensterinside.bl.interfaces.CommentBLLocal;
import de.muensterinside.dao.interfaces.CommentDAOLocal;
import de.muensterinside.dto.CommentListResponse;
import de.muensterinside.dto.ReturncodeResponse;
import de.muensterinside.entities.Comment;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;
import de.muensterinside.util.DtoAssembler;


@Stateless
public class CommentBL implements CommentBLLocal {

	@EJB
	CommentDAOLocal commentDAO;
	
	@EJB
	private DtoAssembler dtoAssembler;
	
	@EJB
	public CommentListResponse getCommentsByLocation(int loc_id){
		CommentListResponse response = new CommentListResponse();
		
		try{
			List<Comment> comments = commentDAO.findByLocation(loc_id);
			
			if(comments.isEmpty()) {
				throw new NoDataException("Es wurden keine Kommentare gefunden");
			}			
			
			response.setCommentList(dtoAssembler.makeDTOCommentList(comments));
		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}

		return response;
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
}
