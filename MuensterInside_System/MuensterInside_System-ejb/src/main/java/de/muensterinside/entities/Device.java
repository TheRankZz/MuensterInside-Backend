package de.muensterinside.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Datenklasse: Bewertung/Stimme
 * 
 * @author Lennart Giesen, Julius Wessing
 */
@Entity
@Table(name = "devices")
public class Device extends BaseEntity {

	@Column(name = "android_uuid", unique = true, nullable = false)
	private String androidUuid;

	@Column(nullable = false)
	private String username;

	@Column(name = "lastlogin_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginAt;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "device")
	private List<Comment> comments;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "device")
	private List<Location> locations;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "device")
	private List<Vote> votes;

	public Device() {
	}

	public Device(String androidUuid, String username) {
		this.androidUuid = androidUuid;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAndroidUuid() {
		return androidUuid;
	}

	public void setAndroidUuid(String androidUuid) {
		this.androidUuid = androidUuid;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public Date getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt() {
		this.lastLoginAt = new Date();
	}
}
