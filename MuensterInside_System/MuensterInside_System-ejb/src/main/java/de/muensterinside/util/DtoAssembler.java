package de.muensterinside.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.muensterinside.dto.CategoryTO;
import de.muensterinside.dto.CommentTO;
import de.muensterinside.dto.DeviceTO;
import de.muensterinside.dto.LocationTO;
import de.muensterinside.entities.Category;
import de.muensterinside.entities.Comment;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;

/**
 * Mappt die Datenklassen in TO-Klassen um
 * @author Lennart Giesen, Julius Wessing
 */
@Stateless
public class DtoAssembler {

	public List<CategoryTO> makeDTOCategoryList(List<Category> categories) {
		ArrayList<CategoryTO> dtoList = new ArrayList<>();
		for (Category category : categories) {
			dtoList.add(this.makeDTO(category));
		}
		return dtoList;
	}

	public List<LocationTO> makeDTOLocationList(List<Location> locations) {
		ArrayList<LocationTO> dtoList = new ArrayList<>();
		for (Location location : locations) {
			dtoList.add(this.makeDTO(location));
		}
		return dtoList;
	}

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
		dto.setCreatedAt(comment.getCreatedAt());
		return dto;
	}

	public DeviceTO makeDTO(Device device) {
		DeviceTO dto = new DeviceTO();
		dto.setId(device.getId());
		dto.setUsername(device.getUsername());
		dto.setAndroidUuid(device.getAndroidUuid());
		return dto;
	}

	public LocationTO makeDTO(Location location) {
		LocationTO dto = new LocationTO();
		dto.setId(location.getId());
		dto.setName(location.getName());
		dto.setLink(location.getLink());
		dto.setDescription(location.getDescription());
		dto.setVotevalue(location.getVoteValue());
		return dto;
	}
	
	public List<CommentTO> makeDTOCommentList(List<Comment> comments) {
		ArrayList<CommentTO> dtoList = new ArrayList<>();
		for (Comment comment : comments) {
			dtoList.add(this.makeDTO(comment));
		}
		return dtoList;
	}
}
