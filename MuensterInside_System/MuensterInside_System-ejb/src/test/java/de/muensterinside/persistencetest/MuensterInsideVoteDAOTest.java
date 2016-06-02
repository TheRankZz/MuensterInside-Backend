//package de.muensterinside.persistencetest;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import javax.ejb.EJB;
//
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.spec.WebArchive;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import de.muensterinside.dao.DeviceDAOLocal;
//import de.muensterinside.dao.LocationDAOLocal;
//import de.muensterinside.dao.VoteDAOLocal;
//import de.muensterinside.entities.Device;
//import de.muensterinside.entities.Location;
//import de.muensterinside.entities.Vote;
//import de.muensterinside.entities.VoteType;
//
//@RunWith(Arquillian.class)
//public class MuensterInsideVoteDAOTest {
//
//
//	@EJB
//	VoteDAOLocal dao;
//	
//	@EJB
//	LocationDAOLocal locationDAO;
//	
//	@EJB
//	DeviceDAOLocal deviceDAO;
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
//		Location location = locationDAO.findById(1);
//		Device device = deviceDAO.findByID(1);
//		VoteType voteType = VoteType.up;
//		
//		Vote vote = new Vote(location, device, voteType);
//		assertTrue (dao.insert(vote)); 
//	}
//	
//	/*
//	@Test
//	public void findByID() throws Exception {
//		Vote vote = dao.findById(1);
//		assert vote!=null : "Kategorie nicht gefunden.";
//	}*/
//	
//	@Test
//	public void findAll() throws Exception {
//		List<Vote> votes = dao.findAll();
//		for(Vote vote : votes) {
//			assert vote!=null : "Vote nicht gefunden.";
//		}
//	}
//	
//	/*
//	@Test
//	public void findByLocationAndDevice() throws Exception {
//		Vote vote = dao.findByLocationAndDevice(1, 1);
//		assert vote!=null : "Vote nicht gefunden.";
//	}*/
//	
//	@Test
//	public void delete() throws Exception {
//		Location location = locationDAO.findById(1);
//		Device device = deviceDAO.findByID(1);
//		VoteType voteType = VoteType.up;
//		
//		Vote vote = new Vote(location, device, voteType);
//		dao.insert(vote);
//		assertTrue (dao.delete(vote.getId()));
//	}
//	
//}