package de.muensterinside.webservices;

import de.muensterinside.bl.interfaces.*;

/**
 * Interface: Webservice für Mobile-Clients
 * @author Lennart Giesen, Julius Wessing
 *
 */
public interface MobileWebservice 
	extends VoteBLLocal, CommentBLLocal, LocationBLLocal, CategoryBLLocal, DeviceBLLocal {
}
