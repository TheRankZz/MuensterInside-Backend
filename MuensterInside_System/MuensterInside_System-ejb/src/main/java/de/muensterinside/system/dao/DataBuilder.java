package de.muensterinside.system.dao;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.*;

import de.muensterinside.system.entities.Category;

@Singleton
@Startup
public class DataBuilder {

	 @PersistenceContext(unitName = "muenster")
	EntityManager em;
	
	@PostConstruct
	private void CreateTestData(){
		
		Category cat = new Category("Test");
		em.persist(cat);
	}
}
