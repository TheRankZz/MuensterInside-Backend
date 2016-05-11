package de.muensterinside.system.entities;

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
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable = false)
	private String lastname;

	@Column(unique = true, nullable = false)
	private int deviceId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "device")
	private List<Comment> comments;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "device")
	private List<Location> location;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "device")
	private List<Vote> votes;

	public Device() {
	}
}
