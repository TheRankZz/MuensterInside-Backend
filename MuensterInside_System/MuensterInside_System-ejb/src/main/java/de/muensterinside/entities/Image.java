package de.muensterinside.entities;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Image extends BaseEntity {
	
	
	public Image() { }
	
	public Image(byte[] imageData, String mimeType, Location location) {
		this.imageData = imageData;
		this.mimeType = mimeType;
		/*this.location = location;*/
	}
	
	/*
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "image")
	private Location location; */
	
	private String mimeType; 

	@Lob
	@Basic(fetch=FetchType.LAZY) 
	private  byte[]  imageData;

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	/*
	public Location getLocation() {
		return location;
	}
	 */
}
