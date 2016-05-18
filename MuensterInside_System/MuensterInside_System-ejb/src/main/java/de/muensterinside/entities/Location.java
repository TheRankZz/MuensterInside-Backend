package de.muensterinside.entities;

import java.util.List;

import javax.persistence.*;

/**
 * Datenklasse: Location
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Entity
@Table(name = "locations") 
public class Location extends BaseEntity {

	private String name;

	private String description;

	private String link;

	private int voteValue;
	
	@OneToOne
	private Image image;

	@ManyToOne
	private Device device;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "location")
	private List<Comment> comments;

	@ManyToOne
	private Category category;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "location")
	private List<Vote> votes;
	
	public Location() {
	}

	public Location(String name, String description, String link, Device device, Category category) {
		this.name = name;
		this.description = description;
		this.link = link;
		this.device = device;
		this.category = category;
	}

	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param description
	 *            the description to set
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
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the voteValue
	 */
	public int getVoteValue() {
		return voteValue;
	}

	/**
	 * @param voteValue
	 *            the voteValue to set
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
	 * @param category
	 *            the category to set
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
	 * 
	 * @return the new VoteValue
	 */
	public int upVote() {
		int temp = this.getVoteValue() + 1;
		this.setVoteValue(temp);
		return temp;
	}

	/**
	 * Zählt den VoteValue um eins runter
	 * 
	 * @return the new VoteValue
	 */
	public int downVote() {
		int temp = this.getVoteValue() - 1;
		this.setVoteValue(temp);
		return temp;
	}
}
