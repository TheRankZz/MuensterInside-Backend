/*
package de.muensterinside.webservicetest;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.muensterinside.webservices.MobileWebserviceImpl;
import de.muensterinside.dto.CategoryListResponse;

//TODO: Fertig implementieren

@RunWith(Arquillian.class)
public class MobileWebserviceTest {

	@EJB
	MobileWebserviceImpl mobileWebservice;
	
	CategoryListResponse catListResponse;
	

	
	@Deployment
  public static WebArchive createDeployment() {
  	return ShrinkWrap.create(WebArchive.class, "test.war")
             .addPackages(true,"de/muensterinside")
             .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
             .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
  }



	@Test
	public void CategoryTest() throws Exception {
		catListResponse = mobileWebservice.getCategories();
		
		assertEquals(catListResponse.getReturnCode(), 0);
	}	
}*/
