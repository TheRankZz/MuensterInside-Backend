package de.muensterinside.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.*;

import de.muensterinside.entities.Category;

@Singleton
@Startup
public class DataBuilder {

	@PersistenceContext
	EntityManager em;
	
	@Resource
	private String category1, category2;
	
	@PostConstruct
	private void CreateTestData(){
		
		String[] test = {category1, category2};
	
		for(int i = 0; i < test.length; i++) {
			Category cat = new Category(test[i]);
			em.persist(cat);
		}
		
		/*Category cat = em.find(Category.class, 1);
		Location loc1 = new Location("Cafe extrablatt", "71-mal in Deutschland und fünfmal im Ausland – wir sorgen überall für das gewisse Extra.", "https://cafe-extrablatt.de/", null, cat);
		em.persist(loc1);
		
		Location loc2 = new Location("Café Sieben", "Die angesagteste Location für Münster und Ibbenbüren.", "www.cafesieben.de", null, cat);
		em.persist(loc2);*/

	}
}
