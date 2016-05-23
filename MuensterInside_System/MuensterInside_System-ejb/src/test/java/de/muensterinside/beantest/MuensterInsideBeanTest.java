package de.muensterinside.beantest;

import static org.junit.Assert.fail;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.muensterinside.services.CommentService;




@RunWith(Arquillian.class)
public class MuensterInsideBeanTest {

	@EJB
	CommentService CommentBL;
	
	

	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test.war")
               .addPackages(true,"de/muensterinside")
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
    }
 

	@Test
	/**
	 * Erster Test
	 */
	public void test1() throws Exception {
		
	}
}
