package de.muensterinside.persistencetest;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.muensterinside.dao.CategoryDAOLocal;
import de.muensterinside.entities.Category;

@RunWith(Arquillian.class)
public class MuensterInsideCategoryDAOTest {


	@EJB
	CategoryDAOLocal dao;
	

	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test1.war")
               .addPackages(true,"de/muensterinside")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 

	/**
	 * Prueft, ob nach dem Startup ein Testkunde namens Emma vom DAO gefunden wird.
	 */
	@Test
	public void insert() throws Exception {
		Category category = new Category();
		assertTrue (dao.insert(category)); 
	}
	
	/*
	@Test
	public void findByID() throws Exception {
		Category category = dao.findByID(1);
		assert category!=null : "Kategorie nicht gefunden.";
	}*/
	
	@Test
	public void findAll() throws Exception {
		List<Category> categories = dao.findAll();
		for(Category category : categories) {
			assert category!=null : "Kategorie nicht gefunden.";
		}
	}
	
	@Test
	public void isExists() throws Exception {
		assertTrue (dao.isExists(2));
	}
	
	@Test
	public void delete() throws Exception {
		Category category = new Category("Test");
		
		dao.insert(category);
		assertTrue (dao.delete(category.getId()));
	}
	
}