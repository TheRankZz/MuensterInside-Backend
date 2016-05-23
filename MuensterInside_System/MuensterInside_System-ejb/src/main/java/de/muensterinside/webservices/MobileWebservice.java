package de.muensterinside.webservices;

import de.muensterinside.services.CategoryServiceLocal;
import de.muensterinside.services.CommentServiceLocal;
import de.muensterinside.services.DeviceServiceLocal;
import de.muensterinside.services.LocationBLLocal;
import de.muensterinside.services.VoteServiceLocal;
/**
 * Interface: Webservice für Mobile-Clients
 * @author Lennart Giesen, Julius Wessing
 *
 */
public interface MobileWebservice 
	extends VoteServiceLocal, CommentServiceLocal, LocationBLLocal, CategoryServiceLocal, DeviceServiceLocal {
}
