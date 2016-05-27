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

import de.muensterinside.dao.CommentDAOLocal;
import de.muensterinside.dao.DeviceDAOLocal;
import de.muensterinside.dao.LocationDAOLocal;
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
		Location location = locationDAO.findById(1);
		Comment comment = new Comment("TestComment", device, location);
		assertTrue (dao.insert(comment)); 
	}
	
	@Test
	public void findByID() throws Exception {
		Comment comment = dao.findByID(1);
		assert comment!=null : "Kommentar nicht gefunden.";
	}
	
	@Test
	public void findAll() throws Exception {
		List<Comment> comments = dao.findAll();
		for(Comment comment : comments) {
			assert comment!=null : "Kommentar nicht gefunden.";
		}
	}
	
	@Test
	public void delete() throws Exception {
		Device device = deviceDAO.findByID(1);
		Location location = locationDAO.findById(1);
		Comment comment = new Comment("TestComment", device, location);
		
		dao.insert(comment);
		assertTrue (dao.delete(comment.getId()));
	}
	
	@Test
	public void findByLocation() throws Exception {
		List<Comment> comments = dao.findByLocation(1);
		for(Comment comment : comments) {
			assert comment!=null : "Kommentar nicht gefunden.";
		}
	}
	
	@Test
	public void findByDevice() throws Exception {
		List<Comment> comments = dao.findByDevice(1);
		for(Comment comment : comments) {
			assert comment!=null : "Kommentar nicht gefunden.";
		}
	}
	
}