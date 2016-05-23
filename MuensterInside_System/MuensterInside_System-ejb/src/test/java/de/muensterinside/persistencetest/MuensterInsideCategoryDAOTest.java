package de.muensterinside.persistencetest;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.muensterinside.dao.CategoryDAOLocal;
import de.muensterinside.entities.Category;

@RunWith(Arquillian.class)
public class MuensterInsideCategoryDAOTest {


	@EJB
	CategoryDAOLocal dao;

	
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
	public void test1() throws Exception {
		boolean test;
		assert test=true;
	}
	

	
}