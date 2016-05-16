package de.muensterinside.entities;

import java.util.List;

import javax.persistence.*;

/**
 * Datenklasse: Bewertung/Stimme
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Entity
@Table(name = "devices") 
public class Device extends BaseEntity {
	
	@Column(unique = true, nullable = false)
	private String deviceId;
	
	@Column(nullable = false)
	private String username;


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "device")
	private List<Comment> comments;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "device")
	private List<Location> location;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "device")
	private List<Vote> votes;
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
}
