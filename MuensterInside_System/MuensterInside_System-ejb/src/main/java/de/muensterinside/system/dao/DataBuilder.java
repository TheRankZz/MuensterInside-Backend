package de.muensterinside.system.dao;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.*;

import de.muensterinside.system.entities.Category;

@Singleton
@Startup
public class DataBuilder {

	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	private void CreateTestData(){
		
		String[] test = {"Essen", "Shopping", "Hotel", "Sehenswürdigkeiten", "Veranstaltungen"};
	
		for(int i = 0; i < test.length; i++) {
			Category cat = new Category(test[i]);
			em.persist(cat);
		}

	}
}
