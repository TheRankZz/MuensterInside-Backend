package de.muensterinside.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Lennart Giesen
 */
@Entity
@Table(name = "images")
public class Image extends BaseEntity {
	
	@Column(name = "mimetype")
	private String mimeType; 
	
	@Lob
	private byte[] content;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="location_id", unique=true)
	private Location location;
	
	
	public Image() { }
	
	public Image(byte[] imageData, String mimeType) {
		this.mimeType = mimeType;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
}
