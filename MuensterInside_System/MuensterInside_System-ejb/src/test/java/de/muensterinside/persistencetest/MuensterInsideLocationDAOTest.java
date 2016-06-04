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
import de.muensterinside.dao.DeviceDAOLocal;
import de.muensterinside.dao.LocationDAOLocal;
import de.muensterinside.entities.Category;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;

@RunWith(Arquillian.class)
public class MuensterInsideLocationDAOTest {


	@EJB
	LocationDAOLocal dao;
	
	@EJB
	DeviceDAOLocal deviceDAO;
	
	@EJB
	CategoryDAOLocal categoryDAO;
	

	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test.war")
               .addPackages(true,"de/muensterinside")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 

	/**
	 * Prueft, ob nach dem Startup ein Testkunde namens Emma vom DAO gefunden wird.
	 */
	@Test
	public void insert() throws Exception {
		Device device = deviceDAO.findByID(1);
		Category category = categoryDAO.findByID(1);
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue (dao.insert(location)); 
	}
	
	@Test
	public void findByID() throws Exception {
		Location location = dao.findById(1);
		assert location!=null : "Location nicht gefunden.";
	}
	
	@Test
	public void findAll() throws Exception {
		List<Location> locations = dao.findAll();
		for(Location location : locations) {
			assert location!=null : "Kategorie nicht gefunden.";
		}
	}
	
	/*
	@Test
	public void isExists() throws Exception {
		assertTrue (dao.isExists(2));
	}*/
	
	@Test
	public void delete() throws Exception {
		Device device = deviceDAO.findByID(1);
		Category category = categoryDAO.findByID(1);
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		
		dao.insert(location);
		assertTrue (dao.delete(location.getId()));
	}
	
	@Test
	public void findByCategory() throws Exception {
		List<Location> locations = dao.findByCategory(1);
		for(Location location : locations) {
			assert location!=null : "Location nicht gefunden.";
		}
	}
	
	@Test
	public void findByDevice() throws Exception {
		List<Location> locations = dao.findByDevice(1);
		for(Location location : locations) {
			assert location!=null : "Location nicht gefunden.";
		}
	}
	
}