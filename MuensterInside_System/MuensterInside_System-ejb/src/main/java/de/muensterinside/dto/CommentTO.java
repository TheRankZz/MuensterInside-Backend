package de.muensterinside.dto;

import java.util.Date;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
public class CommentTO {

	private int id;
	private String text;
	private Date createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
