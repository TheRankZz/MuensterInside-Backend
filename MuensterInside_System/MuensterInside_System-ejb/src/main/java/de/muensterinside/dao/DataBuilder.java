package de.muensterinside.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.*;

import de.muensterinside.entities.Category;
import de.muensterinside.entities.Device;

@Singleton
@Startup
public class DataBuilder {

	@PersistenceContext
	EntityManager em;
	
	@Resource
	private String category1, category2, androidUuid1, androidUuid2, username1, username2, locationName1,
					locationName2;
	
	@PostConstruct
	private void CreateTestData(){
		
		String[] categoryNames = {category1, category2};
		String[] androidUuidNames = {androidUuid1, androidUuid2};
		String[] usernames = {username1, username2};
		String[] locationNames = {locationName1, locationName2};
		
	
		for(int i = 0; i < categoryNames.length; i++) {
			Category category = new Category(categoryNames[i]);
			em.persist(category);
		}
		
		for(int i = 0; i < androidUuidNames.length; i++){
			Device device = new Device(androidUuidNames[i], usernames[i]);
			em.persist(device);
		}
		
		
		
		/*Category cat = em.find(Category.class, 1);
		Location loc1 = new Location("Cafe extrablatt", "71-mal in Deutschland und fünfmal im Ausland – wir sorgen überall für das gewisse Extra.", "https://cafe-extrablatt.de/", null, cat);
		em.persist(loc1);
		
		Location loc2 = new Location("Café Sieben", "Die angesagteste Location für Münster und Ibbenbüren.", "www.cafesieben.de", null, cat);
		em.persist(loc2);*/

	}
}
