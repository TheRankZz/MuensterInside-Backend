package de.muensterinside.system.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Datenklasse: Kommentar
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Entity
public class Comment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private int id;
	
	private String text;
	
	@ManyToOne
	private Device device;
	
	/* Beziehungen */
	@ManyToOne
	private Location location;
		

	public Comment(){}
	
	
	public Comment(String text, Device device, Location location) {
		this.text = text;
		this.device = device;
		this.location = location;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}


	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
}
