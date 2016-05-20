package de.muensterinside.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.muensterinside.bl.interfaces.VoteBLLocal;
import de.muensterinside.dao.interfaces.*;
import de.muensterinside.dto.*;
import de.muensterinside.entities.*;
import de.muensterinside.exceptions.*;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;

//TODO: Klasse kommentieren
@Stateless
public class VoteBL implements VoteBLLocal {

	@EJB
	private VoteDAOLocal daoVote;

	@EJB
	private LocationDAOLocal daoLocation;

	@EJB
	private DeviceDAOLocal daoDevice;

	@EJB
	private DtoAssembler dtoAssembler;

	@Override
	public LocationListResponse getMyVotes(int deviceId) {
		LocationListResponse response = new LocationListResponse();

		try {
			Device dev = daoDevice.findByID(deviceId);
			//TODO: Die Locations werden nicht geladen.
			if (dev.getLocations().isEmpty())
				throw new NoDataException(Messages.NoDataExceptionMsg);
			
			List<LocationTO> list = dtoAssembler.makeDTOLocationList(dev.getLocations());
			if (list.isEmpty())
				throw new NoDataException(Messages.NoSavedExceptionMsg);
			
			response.setLocationList(list);

		} catch (MuensterInsideException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
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

			//TODO: Noch eine Exception erstellen 
			if (daoVote.findByLocationAndDevice(location_id, deviceId) != null)
				throw new MuensterInsideException(123, "Es wurde bereits für diese Location eine Stimme abgegeben!");

			// Transaktion Begin

			Vote vote = new Vote(loc, dev, typ);
			if (!daoVote.insert(vote))
				throw new NoSavedException(Messages.NoDataExceptionMsg);

			if (typ == VoteType.down) {
				loc.downVote();
			} else {
				loc.upVote();
			}
			daoLocation.update(loc);

			// Transaktion End

		} catch (MuensterInsideException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		} catch (Exception e) {
			response.setReturnCode(Messages.SystemErrorCode);
			response.setMessage(e.getMessage());
		}

		return response;
	}
}
