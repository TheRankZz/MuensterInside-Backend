package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import de.muensterinside.dao.interfaces.CommentDAOLocal;
import de.muensterinside.dto.CommentListResponse;
import de.muensterinside.entities.Comment;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;
import de.muensterinside.util.DtoAssembler;

@Local
@Stateless
public class CommentBL {

	@EJB
	CommentDAOLocal commentDAO;
	
	@EJB
	private DtoAssembler dtoAssembler;
	
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
}
