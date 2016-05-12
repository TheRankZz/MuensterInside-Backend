package de.muensterinside.util;

import javax.ejb.Stateless;

import de.muensterinside.dto.CategoryTO;
import de.muensterinside.dto.CommentTO;
import de.muensterinside.dto.DeviceTO;
import de.muensterinside.entities.Category;
import de.muensterinside.entities.Comment;
import de.muensterinside.entities.Device;


@Stateless
public class DtoAssembler {

	  public CategoryTO makeDTO(Category category) {
		  CategoryTO dto = new CategoryTO();
		  dto.setId(category.getId());
		  dto.setName(category.getName());
		  return dto;
	  }
	  
	  public CommentTO makeDTO(Comment comment) {
		  CommentTO dto = new CommentTO();
		  dto.setId(comment.getId());
		  dto.setText(comment.getText());
		  return dto;
	  }
	  
	  public DeviceTO makeDTO(Device device){
		  DeviceTO dto = new DeviceTO();
		  dto.setId(device.getId());
		  dto.setFirstname(device.getFirstname());
		  dto.setLastname(device.getLastname());
		  return dto;
	  }
	  
	  
}
