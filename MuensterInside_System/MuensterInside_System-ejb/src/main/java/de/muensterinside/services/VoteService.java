package de.muensterinside.services;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.jboss.logging.Logger;

//import javax.transaction.UserTransaction;


import de.muensterinside.dao.DeviceDAOLocal;
import de.muensterinside.dao.LocationDAOLocal;
import de.muensterinside.dao.VoteDAOLocal;
import de.muensterinside.dto.IsVotedRepsonse;
import de.muensterinside.dto.LocationListResponse;
import de.muensterinside.dto.LocationTO;
import de.muensterinside.dto.ReturncodeResponse;
import de.muensterinside.entities.Device;
import de.muensterinside.entities.Location;
import de.muensterinside.entities.Vote;
import de.muensterinside.entities.VoteType;
import de.muensterinside.exceptions.MuensterInsideException;
import de.muensterinside.exceptions.NoDataException;
import de.muensterinside.exceptions.NoSavedException;
import de.muensterinside.exceptions.VoteExistsException;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;

//TODO: Klasse kommentieren
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class VoteService implements VoteServiceLocal {

	private static final Logger logger = Logger.getLogger(VoteService.class);

	@EJB
	private VoteDAOLocal daoVote;

	@EJB
	private LocationDAOLocal daoLocation;

	@EJB
	private DeviceDAOLocal daoDevice;

	@EJB
	private DtoAssembler dtoAssembler;

	@Resource
	private EJBContext ctx;

	@Override
	public LocationListResponse getMyVotes(int deviceId) {
		LocationListResponse response = new LocationListResponse();

		try {
			Device dev = daoDevice.findByID(deviceId);
			// TODO: Die Locations werden nicht geladen.
			if (dev.getLocations().isEmpty())
				throw new NoDataException(Messages.NoDataExceptionMsg);

			List<LocationTO> list = dtoAssembler.makeDTOLocationList(dev.getLocations());
			if (list.isEmpty())
				throw new NoDataException(Messages.NoSavedExceptionMsg);

			response.setLocationList(list);
			logger.info("Eine Liste von Location für Device[" + deviceId + "] wird zurückgegeben");
		} catch (MuensterInsideException e) {
			logger.error("Fehler " + e.getErrorCode() + ": " + e.getMessage());
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.fatal("Unbekannter Fehler " + Messages.SystemErrorCode + ":" + e.getMessage());
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	/**
	 * Eine Location hochvoten
	 */
	@Override
	public ReturncodeResponse upVote(int location_id, int deviceId) {
		return vote(location_id, deviceId, VoteType.up);
	}

	/**
	 * Eine Location runtervoten
	 */
	@Override
	public ReturncodeResponse downVote(int location_id, int deviceId) {
		return vote(location_id, deviceId, VoteType.down);
	}

	@Override
	public IsVotedRepsonse isVoted(int location_id, int deviceId) {
		IsVotedRepsonse response = new IsVotedRepsonse();

		try {
			Vote vote = daoVote.findByLocationAndDevice(location_id, deviceId);
			if (vote != null) {
				response.setIsVoted(true);
			}
		} catch (Exception e) {
			logger.fatal("Unbekannter Fehler " + Messages.SystemErrorCode + ":" + e.getMessage());
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}

	/**
	 * 
	 * @param location_id
	 * @param deviceId
	 * @param typ
	 * @return
	 */
	private ReturncodeResponse vote(int location_id, int deviceId, VoteType typ) {

		ReturncodeResponse response = new ReturncodeResponse();
		
		
		try {
			Location loc = daoLocation.findById(location_id);
			if (loc == null)
				throw new NoDataException(Messages.NoDataExceptionMsg);

			Device dev = daoDevice.findByID(deviceId);
			if (dev == null)
				throw new NoDataException(Messages.NoDataExceptionMsg);

			if (daoVote.findByLocationAndDevice(location_id, deviceId) != null)
				throw new VoteExistsException("Es wurde bereits für diese Location eine Stimme abgegeben!");

		
			
			//UserTransaction utx = ctx.getUserTransaction();
			//try {
				// Transaktion Begin
			//	utx.begin();
				
				if (typ == VoteType.down) {
					loc.downVote();
				} else {
					loc.upVote();
				}
				daoLocation.update(loc);

				Vote vote = new Vote(loc, dev, typ);
				if (!daoVote.insert(vote))
					throw new NoSavedException(Messages.NoDataExceptionMsg);
				
				// Transaktion End
			//	utx.commit();
			//} catch (Throwable t) {
			//	utx.rollback();
			//	throw new NoSavedException(Messages.NoDataExceptionMsg);
			//}
			
			logger.info(
					"Es wurde ein Vote für die Location[" + location_id + "] von Device[" + deviceId + "] gespeichert");


		} catch (MuensterInsideException e) {
			logger.error("Fehler " + e.getErrorCode() + ": " + e.getMessage());
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Throwable e) {
			logger.fatal("Unbekannter Fehler " + Messages.SystemErrorCode + ":" + e.getMessage());
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}
}
