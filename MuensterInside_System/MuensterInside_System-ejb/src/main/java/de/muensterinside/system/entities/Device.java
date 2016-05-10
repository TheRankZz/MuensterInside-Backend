package de.muensterinside.system.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Datenklasse: Bewertung/Stimme
 * @author Lennart Giesen, Julius Wessing
 *
 */
@Entity
public class Device implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private int Id; 

	@Column(unique=true, nullable=false)
	private int deviceId;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="device")
	private List<Comment> comments;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="device")
	private List<Location> location;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="device")
	private List<Vote> votes;
	
	public Device() { }
}
