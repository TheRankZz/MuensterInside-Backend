package de.muensterinside.dto;

/**
 * @author Lennart Giesen
 */
public class ImageResponse extends ReturncodeResponse {

	private String imageDataBase64;
	
	private String mimeType;

	public String getImageDataBase64() {
		return imageDataBase64;
	}

	public void setImageDataBase64(String imageDataBase64) {
		this.imageDataBase64 = imageDataBase64;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
}
