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

/**
 * @author Julius Wessing
 */
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
		Category category = new Category("Category1");
		assertTrue ("Kategorie konnte nicht hinzugefügt werden.", dao.insert(category)); 
	}
	
	
	@Test
	public void findByID() throws Exception {
		Category category = new Category("Category2");
		assertTrue ("Kategorie konnte nicht hinzugefügt werden.", dao.insert(category)); 
		Category categoryFind = dao.findByID(category.getId());
		assert categoryFind!=null : "Kategorie nicht gefunden.";
	}
	
	@Test
	public void findAll() throws Exception {
		Category category = new Category("Category3");
		assertTrue ("Kategorie konnte nicht hinzugefügt werden.", dao.insert(category)); 
		List<Category> categories = dao.findAll();
		for(Category categoryLoop : categories) {
			assert categoryLoop!=null : "Kategorie nicht gefunden.";
		}
	}
	
	@Test
	public void isExists() throws Exception {
		Category category = new Category("Category4");
		assertTrue ("Kategorie konnte nicht hinzugefügt werden.", dao.insert(category)); 
		assertTrue ("Es konnte keine Kategorie gefunden werden.", dao.isExists(category.getId()));
	}
	
	@Test
	public void delete() throws Exception {
		Category category = new Category("Category5");
		assertTrue ("Kategorie konnte nicht hinzugefügt werden.", dao.insert(category)); 
		assertTrue (dao.delete(category.getId()));
	}
	
}