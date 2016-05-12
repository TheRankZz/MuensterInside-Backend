package de.muensterinside.dto;

/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
public class LocationTO {

	private int id;
	private String name;
	private String link;
	private int votevalue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getVotevalue() {
		return votevalue;
	}
	public void setVotevalue(int votevalue) {
		this.votevalue = votevalue;
	}
}
