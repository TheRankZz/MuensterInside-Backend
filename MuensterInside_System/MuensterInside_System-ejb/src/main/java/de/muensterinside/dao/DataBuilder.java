package de.muensterinside.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.*;

import de.muensterinside.entities.Category;
import de.muensterinside.entities.Comment;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;
import de.muensterinside.entities.Vote;
import de.muensterinside.entities.VoteType;

@Singleton
@Startup
public class DataBuilder {

	@PersistenceContext
	EntityManager em;
	
	@Resource
	private String categoryName1, categoryName2, androidUuid1, androidUuid2, username1, username2, locationName1,
					locationName2, locationDescription1, locationDescription2, locationLink1, locationLink2, commentText1, commentText2;
	
	
	
	@PostConstruct
	private void CreateTestData(){
		
		String[] categoryNames = {categoryName1, categoryName2};
		String[] androidUuidNames = {androidUuid1, androidUuid2};
		String[] usernames = {username1, username2};
		String[] locationNames = {locationName1, locationName2};
		String[] locationDescriptions = {locationDescription1, locationDescription2};
		String[] locationLinks = {locationLink1, locationLink2};
		String[] comments = {commentText1, commentText2};
		List<Category> categories = new ArrayList<Category>();
		List<Device> devices = new ArrayList<Device>();
		List<Location> locations = new ArrayList<Location>();
		VoteType[] voteTypes = {VoteType.up, VoteType.up};
		
	
		for(int i = 0; i < categoryNames.length; i++) {
			Category category = new Category(categoryNames[i]);
			em.persist(category);
			categories.add(category);
		}
		
		for(int i = 0; i < androidUuidNames.length; i++) {
			Device device = new Device(androidUuidNames[i], usernames[i]);
			em.persist(device);
			devices.add(device);
		}
		
		for(int i = 0; i < locationNames.length; i++){
			Location location = new Location(locationNames[i], locationDescriptions[i], locationLinks[i], devices.get(i), categories.get(i));
			em.persist(location);
			locations.add(location);
		}
		
		for(int i = 0; i < locations.size(); i++) {
			Vote vote = new Vote(locations.get(i), devices.get(i), voteTypes[i]);
			em.persist(vote);
		}
		
		for(int i = 0; i < comments.length; i++){
			Comment comment = new Comment(comments[i], devices.get(i), locations.get(i));
			em.persist(comment);
		}
	}
}
