package de.muensterinside.system.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Datenklasse: Bewertung/Stimme
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Entity
@Table(name = "votes") 
public class Vote extends BaseEntity {

	private VoteType type;

	@ManyToOne
	private Location location;

	@ManyToOne
	private Device device;

	public Vote() {
	}

	public Vote(Location location, Device device, VoteType type) {
		this.location = location;
		this.device = device;
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public VoteType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(VoteType type) {
		this.type = type;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

}
