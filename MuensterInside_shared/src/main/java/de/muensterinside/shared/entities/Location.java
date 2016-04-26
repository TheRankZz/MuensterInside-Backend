package de.muensterinside.shared.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Datenklasse: Location
 * @author Lennart Giesen, Julius Wessing
 *
 */
public class Location implements Serializable { 
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String description;
	
	private String link;
	
	private int voteValue;
	
	private String deviceId;
	
	/* Beziehungen */
	
	private List<Comment> comments;
	
	private Category category;
	
	private List<Vote> votes;
	

	
	/**
	 * 
	 * @param name
	 * @param deviceId
	 * @param category
	 */
	public Location(String name, String deviceId, Category category) {
		this.name = name;
		this.deviceId = deviceId;
		this.category = category;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the voteValue
	 */
	public int getVoteValue() {
		return voteValue;
	}

	/**
	 * @param voteValue the voteValue to set
	 */
	public void setVoteValue(int voteValue) {
		this.voteValue = voteValue;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the votes
	 */
	public List<Vote> getVotes() {
		return votes;
	}
	
	/**
	 * Zählt den VoteValue um eins hoch
	 * @return the new VoteValue
	 */
	public int upVote() {
		int temp = this.getVoteValue() + 1;
		this.setVoteValue(temp);
		return temp;
	}
	
	/**
	 * Zählt den VoteValue um eins runter
	 * @return the new VoteValue
	 */
	public int downVote() {
		int temp = this.getVoteValue() - 1;
		this.setVoteValue(temp);
		return temp;
	}
}
