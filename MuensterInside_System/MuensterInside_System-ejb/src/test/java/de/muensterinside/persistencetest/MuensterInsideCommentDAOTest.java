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
import de.muensterinside.dao.CommentDAOLocal;
import de.muensterinside.dao.DeviceDAOLocal;
import de.muensterinside.dao.LocationDAOLocal;
import de.muensterinside.entities.Category;
import de.muensterinside.entities.Comment;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;

@RunWith(Arquillian.class)
public class MuensterInsideCommentDAOTest {


	@EJB
	CommentDAOLocal dao;
	
	@EJB
	DeviceDAOLocal deviceDAO;
	
	@EJB
	LocationDAOLocal locationDAO;
	
	@EJB
	CategoryDAOLocal categoryDAO;
	

	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test2.war")
               .addPackages(true,"de/muensterinside")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 

	/**
	 * Prueft, ob nach dem Startup ein Testkunde namens Emma vom DAO gefunden wird.
	 */
	@Test
	public void insert() throws Exception {
		Device device = new Device("androidUuid1", "username1");
		assertTrue ("Es konnte kein Device angelegt werden", deviceDAO.insert(device)); 
		
		Category category = new Category("Category1");
		assertTrue ("Es konnte kein Device angelegt werden", categoryDAO.insert(category)); 
		
		Location location = new Location("location1", "locationDe", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 
		
		Comment comment = new Comment("TestComment", device, location);
		assertTrue ("Es konnte kein Kommentar angelegt werden", dao.insert(comment)); 
	}
	
	
	@Test
	public void findByID() throws Exception {
		Device device = new Device("androidUuid2", "username2");
		assertTrue ("Es konnte kein Device angelegt werden", deviceDAO.insert(device)); 
		
		Category category = new Category("Category2");
		assertTrue ("Es konnte kein Device angelegt werden", categoryDAO.insert(category)); 
		
		Location location = new Location("location2", "locationDe", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 
		
		Comment comment = new Comment("TestComment", device, location);
		assertTrue ("Es konnte kein Kommentar angelegt werden", dao.insert(comment)); 
		
		
		 assert dao.findByID(comment.getId())!=null : "Kommentar nicht gefunden.";
	}
	
	
	@Test
	public void findAll() throws Exception {
		Device device = new Device("androidUuid3", "username3");
		assertTrue ("Es konnte kein Device angelegt werden", deviceDAO.insert(device)); 
		
		Category category = new Category("Category3");
		assertTrue ("Es konnte kein Device angelegt werden", categoryDAO.insert(category)); 
		
		Location location = new Location("location3", "locationDe", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 
		
		Comment comment = new Comment("TestComment", device, location);
		assertTrue ("Es konnte kein Kommentar angelegt werden", dao.insert(comment)); 
		
		
		List<Comment> comments = dao.findAll();
		for(Comment commentLoop : comments) {
			assert commentLoop!=null : "Kommentar nicht gefunden.";
		}
	}
	
	
	@Test
	public void delete() throws Exception {
		Device device = new Device("androidUuid4", "username4");
		assertTrue ("Es konnte kein Device angelegt werden", deviceDAO.insert(device)); 
		
		Category category = new Category("Category4");
		assertTrue ("Es konnte kein Device angelegt werden", categoryDAO.insert(category)); 
		
		Location location = new Location("location4", "locationDe", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 
		
		Comment comment = new Comment("TestComment", device, location);
		assertTrue ("Es konnte kein Kommentar angelegt werden", dao.insert(comment)); 
		
		assertTrue (dao.delete(comment.getId()));
	}
	
	@Test
	public void findByLocation() throws Exception {
		Device device = new Device("androidUuid5", "username5");
		assertTrue ("Es konnte kein Device angelegt werden", deviceDAO.insert(device)); 
		
		Category category = new Category("Category5");
		assertTrue ("Es konnte kein Device angelegt werden", categoryDAO.insert(category)); 
		
		Location location = new Location("location5", "locationDe", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 
		
		Comment comment = new Comment("TestComment", device, location);
		assertTrue ("Es konnte kein Kommentar angelegt werden", dao.insert(comment)); 
		
		
		List<Comment> comments = dao.findByLocation(location.getId());
		for(Comment commentLoop : comments) {
			assert commentLoop!=null : "Kommentar nicht gefunden.";
		}
	}
	
	@Test
	public void findByDevice() throws Exception {
		Device device = new Device("androidUuid6", "username6");
		assertTrue ("Es konnte kein Device angelegt werden", deviceDAO.insert(device)); 
		
		Category category = new Category("Category6");
		assertTrue ("Es konnte kein Device angelegt werden", categoryDAO.insert(category)); 
		
		Location location = new Location("location6", "locationDe", "http://...", device, category);
		assertTrue ("Es konnte keine Location angelegt werden", locationDAO.insert(location)); 
		
		Comment comment = new Comment("TestComment", device, location);
		assertTrue ("Es konnte kein Kommentar angelegt werden", dao.insert(comment)); 
		
		
		List<Comment> comments = dao.findByDevice(device.getId());
		for(Comment commentLoop : comments) {
			assert commentLoop!=null : "Kommentar nicht gefunden.";
		}
	}
	
}