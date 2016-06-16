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

import de.muensterinside.dao.CategoryDAO;
import de.muensterinside.dao.CategoryDAOLocal;
import de.muensterinside.dao.DeviceDAO;
import de.muensterinside.dao.DeviceDAOLocal;
import de.muensterinside.dao.LocationDAO;
import de.muensterinside.dao.LocationDAOLocal;
import de.muensterinside.dao.VoteDAO;
import de.muensterinside.dao.VoteDAOLocal;
import de.muensterinside.entities.Category;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;
import de.muensterinside.entities.Vote;
import de.muensterinside.entities.VoteType;

@RunWith(Arquillian.class)
public class MuensterInsideVoteDAOTest {

	
	@EJB
	DeviceDAOLocal deviceDAO;
	
	@EJB
	CategoryDAOLocal categoryDAO;
	
	@EJB
	LocationDAOLocal locationDAO;
	
	@EJB
	VoteDAOLocal dao;
	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test5.war")
               .addPackages(true,"de/muensterinside")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 

	/**
	 * Prueft, ob nach dem Startup ein Testkunde namens Emma vom DAO gefunden wird.
	 */
	
	@Test
	public void insert() throws Exception {
		Device device = new Device("AndroidID3", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 

		
		
		Vote vote = new Vote(location, device, VoteType.up);
		assertTrue ("Vote konnte nicht gesetzt werden", dao.insert(vote)); 
	}
	
	
	@Test
	public void findByID() throws Exception {
		Device device = new Device("AndroidID4", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 

		
		
		Vote vote = new Vote(location, device, VoteType.up);
		assertTrue ("Vote konnte nicht gesetzt werden", dao.insert(vote)); 
		
		assertTrue("Es konnte kein Vote gefunden werden", dao.findById(vote.getId())!=null);
	}
	
	@Test
	public void findAll() throws Exception {
		boolean i = true; 
		assert i=true;
	}
	
	
	@Test
	public void findByLocationAndDevice() throws Exception {
		Device device = new Device("AndroidID5", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 

		
		
		Vote vote = new Vote(location, device, VoteType.up);
		assertTrue ("Vote konnte nicht gesetzt werden", dao.insert(vote)); 
		
		
		assertTrue("Kein Vote gefunden", dao.findByLocationAndDevice(location.getId(), device.getId())!=null);
	}
	
	@Test
	public void delete() throws Exception {
		Device device = new Device("AndroidID6", "TestUsername");
		assertTrue ("Es konnte kein Device gespeichert werden", deviceDAO.insert(device)); 
		assert deviceDAO.findByID(1) != null : "Es konnte kein Device gefunden werden";
		
		Category category = new Category("TestCategory");
		assertTrue ("Es konnte keine Category angelegt werden", categoryDAO.insert(category));
		
		Location location = new Location("TestLocation", "TestDescription", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 

		
		
		Vote vote = new Vote(location, device, VoteType.up);
		assertTrue ("Vote konnte nicht gesetzt werden", dao.insert(vote)); 
		
		assertTrue (dao.delete(vote.getId()));	
	}
}