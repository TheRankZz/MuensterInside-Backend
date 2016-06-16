package de.muensterinside.entities;

import javax.persistence.*;

/**
 * Datenklasse: Kommentar
 * 
 * @author Lennart Giesen
 */
@Entity
@Table(name = "comments") 
public class Comment extends BaseEntity {

	@Column(nullable = false, length=1000)
	private String text;

	@ManyToOne
	private Device device;

	/* Beziehungen */
	@ManyToOne
	private Location location;

	public Comment() {
	}

	public Comment(String text, Device device, Location location) {
		this.text = text;
		this.device = device;
		this.location = location;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Location getLocation() {
		return location;
	}
}
