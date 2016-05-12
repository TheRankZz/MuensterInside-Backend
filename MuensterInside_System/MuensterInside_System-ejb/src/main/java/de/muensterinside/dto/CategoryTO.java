package de.muensterinside.dto;


/**
 * 
 * @author Lennart Giesen, Julius Wessing
 *
 */
public class CategoryTO extends DataTransferObject {

	private int id;
	private String name;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
