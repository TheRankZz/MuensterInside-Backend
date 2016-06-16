package de.muensterinside.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.*;

import de.muensterinside.entities.Category;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;

/**
 * @author Julius Wessing
 */
@Singleton
@Startup
public class DataBuilder {

	@PersistenceContext
	EntityManager em;
	
	@Resource
	private String categoryName1, categoryName2, categoryName3, categoryName4, 
					androidUuid1, androidUuid2, androidUuid3, androidUuid4, androidUuid5, androidUuid6, androidUuid7, 
					username1, username2, username3, username4, username5, username6, username7, 
					locationName1Cat1, locationName2Cat1, locationName3Cat1, locationName4Cat1, locationName5Cat1, locationName6Cat1, locationName7Cat1, 
					locationName1Cat2,locationName2Cat2, locationName3Cat2, locationName4Cat2, locationName5Cat2, locationName6Cat2, locationName7Cat2, 
					locationName1Cat3, locationName2Cat3, locationName3Cat3, locationName4Cat3, locationName5Cat3, locationName6Cat3, locationName7Cat3, 
					locationName1Cat4, locationName2Cat4, locationName3Cat4, locationName4Cat4, locationName5Cat4, locationName6Cat4, locationName7Cat4, 
					locationDescription1Cat1, locationDescription2Cat1, locationDescription3Cat1,locationDescription4Cat1,locationDescription5Cat1,locationDescription6Cat1, locationDescription7Cat1,
					locationDescription1Cat2, locationDescription2Cat2, locationDescription3Cat2,locationDescription4Cat2,locationDescription5Cat2,locationDescription6Cat2, locationDescription7Cat2,
					locationDescription1Cat3, locationDescription2Cat3, locationDescription3Cat3,locationDescription4Cat3,locationDescription5Cat3,locationDescription6Cat3, locationDescription7Cat3,
					locationDescription1Cat4, locationDescription2Cat4, locationDescription3Cat4,locationDescription4Cat4,locationDescription5Cat4,locationDescription6Cat4, locationDescription7Cat4,
					locationLink1Cat1, locationLink2Cat1, locationLink3Cat1, locationLink4Cat1, locationLink5Cat1, locationLink6Cat1, locationLink7Cat1,
					locationLink1Cat2, locationLink2Cat2, locationLink3Cat2, locationLink4Cat2, locationLink5Cat2, locationLink6Cat2, locationLink7Cat2,
					locationLink1Cat3, locationLink2Cat3, locationLink3Cat3, locationLink4Cat3, locationLink5Cat3, locationLink6Cat3, locationLink7Cat3,
					locationLink1Cat4, locationLink2Cat4, locationLink3Cat4, locationLink4Cat4, locationLink5Cat4, locationLink6Cat4, locationLink7Cat4;
	
	Random rand = new Random();
	
	
	
	@PostConstruct
	private void CreateTestData(){
		
		String[] categoryNames = {categoryName1, categoryName2, categoryName3, categoryName4};
		String[] androidUuidNames = {androidUuid1, androidUuid2, androidUuid3, androidUuid4, androidUuid5, androidUuid6, androidUuid7};
		String[] usernames = {username1, username2, username3, username4, username5, username6, username7};
		String[] locationNamesCat1 = {locationName1Cat1, locationName2Cat1, locationName3Cat1, locationName4Cat1, locationName5Cat1, locationName6Cat1, locationName7Cat1};
		String[] locationNamesCat2 = {locationName1Cat2, locationName2Cat2, locationName3Cat2, locationName4Cat2, locationName5Cat2, locationName6Cat2, locationName7Cat2};
		String[] locationNamesCat3 = {locationName1Cat3, locationName2Cat3, locationName3Cat3, locationName4Cat3, locationName5Cat3, locationName6Cat3, locationName7Cat3};
		String[] locationNamesCat4 = {locationName1Cat4, locationName2Cat4, locationName3Cat4, locationName4Cat4, locationName5Cat4, locationName6Cat4, locationName7Cat4};
		String[] locationDescriptionsCat1 = {locationDescription1Cat1, locationDescription2Cat1, locationDescription3Cat1, locationDescription4Cat1, locationDescription5Cat1, locationDescription6Cat1, locationDescription7Cat1};
		String[] locationDescriptionsCat2 = {locationDescription1Cat2, locationDescription2Cat2, locationDescription3Cat2, locationDescription4Cat2, locationDescription5Cat2, locationDescription6Cat2, locationDescription7Cat2};
		String[] locationDescriptionsCat3 = {locationDescription1Cat3, locationDescription2Cat3, locationDescription3Cat3, locationDescription4Cat3, locationDescription5Cat3, locationDescription6Cat3, locationDescription7Cat3};
		String[] locationDescriptionsCat4 = {locationDescription1Cat4, locationDescription2Cat4, locationDescription3Cat4, locationDescription4Cat4, locationDescription5Cat4, locationDescription6Cat4, locationDescription7Cat4};
		String[] locationLinksCat1 = {locationLink1Cat1, locationLink2Cat1, locationLink3Cat1, locationLink4Cat1, locationLink5Cat1, locationLink6Cat1, locationLink7Cat1};
		String[] locationLinksCat2 = {locationLink1Cat2, locationLink2Cat2, locationLink3Cat2, locationLink4Cat2, locationLink5Cat2, locationLink6Cat2, locationLink7Cat2};
		String[] locationLinksCat3 = {locationLink1Cat3, locationLink2Cat3, locationLink3Cat3, locationLink4Cat3, locationLink5Cat3, locationLink6Cat3, locationLink7Cat3};
		String[] locationLinksCat4 = {locationLink1Cat4, locationLink2Cat4, locationLink3Cat4, locationLink4Cat4, locationLink5Cat4, locationLink6Cat4, locationLink7Cat4};
		List<Category> categories = new ArrayList<Category>();
		List<Device> devices = new ArrayList<Device>();
		List<Location> locations = new ArrayList<Location>();
	
		for(int i = 0; i < androidUuidNames.length; i++) {
			Device device = new Device(androidUuidNames[i], usernames[i]);
			em.persist(device);
			devices.add(device);
		}
	
		for(int i = 0; i < categoryNames.length; i++) {
			Category category = new Category(categoryNames[i]);
			em.persist(category);
			categories.add(category);
		}
		
		
		
		for(int i = 0; i < locationNamesCat3.length; i++){
			Location location = new Location(locationNamesCat3[i], locationDescriptionsCat3[i], locationLinksCat3[i], null, categories.get(2));
			location.setVoteValue(rand.nextInt(50));
			em.persist(location);
			locations.add(location);
		}
		
		
		
		for(int i = 0; i < locationNamesCat1.length; i++){
			Location location = new Location(locationNamesCat1[i], locationDescriptionsCat1[i], locationLinksCat1[i], null, categories.get(0));
			location.setVoteValue(rand.nextInt(50));
			em.persist(location);
			locations.add(location);
		}
		
		for(int i = 0; i < locationNamesCat2.length; i++){
			Location location = new Location(locationNamesCat2[i], locationDescriptionsCat2[i], locationLinksCat2[i], null, categories.get(1));
			location.setVoteValue(rand.nextInt(50));
			em.persist(location);
			locations.add(location);
		}
		

		
		for(int i = 0; i < locationNamesCat4.length; i++){
			Location location = new Location(locationNamesCat4[i], locationDescriptionsCat4[i], locationLinksCat4[i], null, categories.get(3));
			location.setVoteValue(rand.nextInt(50));
			em.persist(location);
			locations.add(location);
		}
		
	}
}
