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
    	return ShrinkWrap.create(WebArchive.class, "test4.war")
               .addPackages(true,"de/muensterinside")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 

	/**
	 * Prueft, ob nach dem Startup ein Testkunde namens Emma vom DAO gefunden wird.
	 */
	@Test
	public void insert() throws Exception {
		Device device = new Device("TestAndroidID1", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", dao.insert(location)); 
	}
	
	@Test
	public void findByID() throws Exception {
		Device device = new Device("TestAndroid4", "TestUsername4");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", dao.insert(location)); 
		
		assertTrue("Es konnte keine Location gefunden werden", dao.findById(location.getId()) != null);
	}
	
	@Test
	public void findAll() throws Exception {
		Device device = new Device("TestAndroidID2", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", dao.insert(location)); 
		
		List<Location> locations = dao.findAll();
		for(Location locationLoop : locations) {
			assert locationLoop!=null : "Location nicht gefunden.";
		}
	}
	
	
	@Test
	public void isExists() throws Exception {
		Device device = new Device("TestAndroidID5", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", dao.insert(location)); 
		
		assertTrue ("Es gibt kein Device", dao.isExists(location.getId()));
	}
	
	@Test
	public void delete() throws Exception {
		Device device = new Device("TestAndroidID10", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", dao.insert(location)); 

		assertTrue (dao.delete(location.getId()));
	}
	
	@Test
	public void findByCategory() throws Exception {
		Device device = new Device("TestAndroidID7", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", dao.insert(location)); 
		
		
		List<Location> locations = dao.findByCategory(category.getId());
		for(Location locationLoop : locations) {
			assert locationLoop!=null : "Location nicht gefunden.";
		}
	}
	
	@Test
	public void findByDevice() throws Exception {
		Device device = new Device("TestAndroidID9", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", dao.insert(location)); 
		
		List<Location> locations = dao.findByDevice(device.getId());
		for(Location locationLoop : locations) {
			assert locationLoop!=null : "Location nicht gefunden.";
		}
	}
	
}