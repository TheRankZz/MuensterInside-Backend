package de.muensterinside.dto;

public class ImageResponse extends ReturncodeResponse {
	
	private byte[] imageBytes;

	public byte[] getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
}
