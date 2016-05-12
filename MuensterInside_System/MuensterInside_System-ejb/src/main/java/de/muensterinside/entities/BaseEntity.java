package de.muensterinside.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Basis-Klasse für die Entitäten
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;  

	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Basic(optional = false)  
    @Column(name = "id", nullable = false) 
	private int id;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Erstelldatum setzen bevor INSERT ausgeführt wird
	 */
	@PrePersist
	public void setCreationDate() {
		this.createdAt = new Date();
	}

	/**
	 * Änderungsdatum setzen bevor UPDATE ausgeführt wird
	 */
	@PreUpdate
	public void setChangeDate() {
		this.updatedAt = new Date();
	}
}
