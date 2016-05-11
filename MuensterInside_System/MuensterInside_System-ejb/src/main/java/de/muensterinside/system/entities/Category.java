package de.muensterinside.system.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Datenklasse: Kategorie
 * 
 * @author Lennart Giesen, Julius Wessing
 * 
 */
@Entity
@Table(name = "categories")  
public class Category extends BaseEntity {

	private String name;

	/* Beziehungen */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
	private List<Location> locations;

	public Category() {
	}

	public Category(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Location> getLocations() {
		return locations;
	}
}
