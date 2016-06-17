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

import de.muensterinside.dao.DeviceDAOLocal;
import de.muensterinside.entities.Device;

/**
 * @author Julius Wessing
 */
@RunWith(Arquillian.class)
public class MuensterInsideDeviceDAOTest {


	@EJB
	DeviceDAOLocal dao;
	

	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test3.war")
               .addPackages(true,"de/muensterinside")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 

	/**
	 * Prueft, ob nach dem Startup ein Testkunde namens Emma vom DAO gefunden wird.
	 */
	@Test
	public void insert() throws Exception {
		Device device = new Device("TestAndroidUuid1", "TestUsername");
		assertTrue (dao.insert(device)); 
	}
	
	@Test
	public void findByID() throws Exception {
		Device device = new Device("TestAndroidUuid2", "TestUsername2");
		assertTrue ("Es konnte kein Device gespeichert werden", dao.insert(device)); 
		
		assert dao.findByID(device.getId()) != null : "Es konnte kein Device gefunden werden";
	}
	
	@Test
	public void findAll() throws Exception {
		Device device = new Device("TestAndroidUuid3", "TestUsername3");
		assertTrue ("Es konnte kein Device gespeichert werden", dao.insert(device)); 
		
		List<Device> devices = dao.findAll();
		for(Device deviceLoop : devices) {
			assert deviceLoop!=null : "Device nicht gefunden.";
		}
	}
	
	@Test
	public void delete() throws Exception {
		Device device = new Device("TestAndroidUuid4", "TestUsername4");
		assertTrue ("Es konnte kein Device gespeichert werden", dao.insert(device)); 
		
		assertTrue ("Devie konnte nicht gelöscht werden", dao.delete(device.getId()));
	}
	
	@Test
	public void findByAndroidUuid() throws Exception {
		Device device = new Device("TestAndroidUuid5", "TestUsername5");
		assertTrue ("Es konnte kein Device gespeichert werden", dao.insert(device)); 
		
		assert dao.findByAndroidUuid(device.getAndroidUuid())!=null : "Device nicht gefunden.";
	}
	
	@Test
	public void isExists() throws Exception {
		Device device = new Device("TestAndroidUuid6", "TestUsername6");
		assertTrue ("Es konnte kein Device gespeichert werden", dao.insert(device)); 
		
		assertTrue (dao.isExists(device.getId()));
	}
	
}