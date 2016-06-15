//package de.muensterinside.webservicetest;
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
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import de.muensterinside.webservices.MobileWebserviceImpl;
//import de.muensterinside.dto.*;
//
////TODO: Kommentare hinzufügen
//
//@RunWith(Arquillian.class)
//public class MobileWebserviceTest {
//
//	@EJB
//	MobileWebserviceImpl mobileWebservice;
//	
//	CategoryListResponse catListResponse;
//	
//	LocationResponse locResponse;
//	
//	DeviceResponse deviceResponse;
//	
//	IsVotedRepsonse isVotedResponse;
//	
//	CommentListResponse comListResponse;
//	
//	ReturncodeResponse returnCodeRe;
//	
//	LocationListResponse locListResponse;
//	
//	
//	
//	
//
//	
//	@Deployment
//  public static WebArchive createDeployment() {
//  	return ShrinkWrap.create(WebArchive.class, "test.war")
//             .addPackages(true,"de/muensterinside")
//             .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
//             .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
//  }
//
//
//
//	@Test
//	public void CategoryTest() throws Exception {
//		catListResponse = mobileWebservice.getCategories();
//		
//		assertEquals(catListResponse.getReturnCode(), 0);
//	}	
//	
//	@Test
//	public void registerTest() throws Exception {
//		deviceResponse = mobileWebservice.register("DeviceID", "testUser");
//		assertEquals(deviceResponse.getReturnCode(), 0);
//	}
//	
//	@Test
//	public void CommentLocationTest() {
//
//		deviceResponse = mobileWebservice.login("DeviceID");
//		assertEquals(deviceResponse.getReturnCode(), 0);
//		
//		returnCodeRe = mobileWebservice.saveLocation("TestLocation", "Dies ist eine TesLocation", "http://", 1, deviceResponse.getDevice().getId());
//		assertEquals(returnCodeRe.getReturnCode(), 0);
//		
//		
//		returnCodeRe = mobileWebservice.saveComment("TestKommentar", deviceResponse.getDevice().getId(), 1);
//		assertEquals(returnCodeRe.getReturnCode(), 0);
//		
//		comListResponse = mobileWebservice.getMyComments(deviceResponse.getDevice().getId());
//		assertEquals(comListResponse.getReturnCode(), 0);
//		
//		returnCodeRe = mobileWebservice.deleteComment(comListResponse.getCommentList().get(0).getId());
//		assertEquals(returnCodeRe.getReturnCode(), 0);
//	}
//	
//	
//
//	@Test
//	public void LocationCommentTest() {
//		
//		deviceResponse = mobileWebservice.login("DeviceID");
//		assertEquals(deviceResponse.getReturnCode(), 0);
//		
//		returnCodeRe = mobileWebservice.saveLocation("TestLocation", "Dies ist eine TesLocation", "http://", 1, deviceResponse.getDevice().getId());
//		assertEquals(returnCodeRe.getReturnCode(), 0);
//
//		locListResponse = mobileWebservice.getLocationsByCategory(1);
//		assertEquals(locListResponse.getReturnCode(), 0);
//		List<LocationTO> locations = locListResponse.getLocationList();
//		
//		locListResponse = mobileWebservice.getMyLocations(deviceResponse.getDevice().getId());
//		assertEquals(locListResponse.getReturnCode(), 0);
//		
//
//		locResponse = mobileWebservice.getLocation(1);
//		assertEquals(locResponse.getReturnCode(), 0);
//		
//		returnCodeRe = mobileWebservice.saveComment("TestKommentar", deviceResponse.getDevice().getId(), locations.get(1).getId());
//		assertEquals(returnCodeRe.getReturnCode(), 0);
//		
//		comListResponse = mobileWebservice.getCommentsByLocation(locations.get(1).getId());
//		assertEquals(comListResponse.getReturnCode(), 0);	
//	}
//	
//	@Test
//	public void LocationVoteTest() {
//
//		deviceResponse = mobileWebservice.login("DeviceID");
//		assertEquals(deviceResponse.getReturnCode(), 0);
//		
//		//TODO: LocationResponse implementieren?
//		returnCodeRe = mobileWebservice.saveLocation("TestLocation", "Dies ist eine TesLocation", "http://", 1, deviceResponse.getDevice().getId());
//		assertEquals(returnCodeRe.getReturnCode(), 0);
//		
//		locListResponse = mobileWebservice.getMyLocations(deviceResponse.getDevice().getId());
//		assertEquals(locListResponse.getReturnCode(), 0);
//		
//		
//		returnCodeRe = mobileWebservice.downVote(locListResponse.getLocationList().get(0).getId(), deviceResponse.getDevice().getId());
//		assertEquals(deviceResponse.getReturnCode(), 0);
//		
//		isVotedResponse = mobileWebservice.isVoted(locListResponse.getLocationList().get(0).getId(), deviceResponse.getDevice().getId());
//		assertEquals(isVotedResponse.isIsVoted(), true);
//	}
//
//}
