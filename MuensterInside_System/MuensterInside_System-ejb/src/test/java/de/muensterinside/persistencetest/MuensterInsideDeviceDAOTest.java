//package de.muensterinside.persistencetest;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import javax.ejb.EJB;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.spec.WebArchive;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import de.muensterinside.dao.CommentDAOLocal;
//import de.muensterinside.dao.DeviceDAOLocal;
//import de.muensterinside.dao.LocationDAOLocal;
//import de.muensterinside.entities.Comment;
//import de.muensterinside.entities.Device;
//import de.muensterinside.entities.Location;
//
//@RunWith(Arquillian.class)
//public class MuensterInsideDeviceDAOTest {
//
//
//	@EJB
//	DeviceDAOLocal dao;
//	
//
//	
//	@Deployment
//    public static WebArchive createDeployment() {
//    	return ShrinkWrap.create(WebArchive.class, "test.war")
//               .addPackages(true,"de/muensterinside")
//               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
//               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
//    }
// 
//
//	/**
//	 * Prueft, ob nach dem Startup ein Testkunde namens Emma vom DAO gefunden wird.
//	 */
//	@Test
//	public void insert() throws Exception {
//		Device device = new Device("TestAndroidUuid", "TestUsername");
//		assertTrue (dao.insert(device)); 
//	}
//	
//	@Test
//	public void findByID() throws Exception {
//		Device device = dao.findByID(1);
//		assert device!=null : "Device nicht gefunden.";
//	}
//	
//	@Test
//	public void findAll() throws Exception {
//		List<Device> devices = dao.findAll();
//		for(Device device : devices) {
//			assert device!=null : "Device nicht gefunden.";
//		}
//	}
//	
//	@Test
//	public void delete() throws Exception {
//		Device device = new Device("TestAndroidUuid", "TestUsername");
//		
//		dao.insert(device);
//		assertTrue (dao.delete(device.getId()));
//	}
//	
//	@Test
//	public void findByAndroidUuid() throws Exception {
//		Device device = dao.findByAndroidUuid("TestAndroidUuid");
//		assert device!=null : "Device nicht gefunden.";
//	}
//	
//	/*
//	@Test
//	public void isExists() throws Exception {
//		assertTrue (dao.isExists(2));
//	}*/
//	
//}