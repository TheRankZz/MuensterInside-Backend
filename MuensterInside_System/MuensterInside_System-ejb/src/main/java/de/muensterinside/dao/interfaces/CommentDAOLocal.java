package de.muensterinside.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import de.muensterinside.entities.Comment;

@Local
public interface CommentDAOLocal {

	public Comment findByID(int id);
	
	public List<Comment> findAll();
	
	public List<Comment> findByLocation(int loc_id);
	
	public boolean insert(Comment comment);
	
	public Comment update(Comment comment);
	
	public boolean delete(int comment_id);

	List<Comment> findByDevice(String dev_id);
}
