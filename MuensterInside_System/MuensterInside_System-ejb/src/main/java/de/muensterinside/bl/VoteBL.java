package de.muensterinside.bl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.muensterinside.bl.interfaces.VoteBLLocal;
import de.muensterinside.dao.interfaces.*;
import de.muensterinside.dto.*;
import de.muensterinside.entities.*;
import de.muensterinside.exceptions.*;
import de.muensterinside.util.DtoAssembler;
import de.muensterinside.util.Messages;

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
	public LocationListResponse getMyVotes(String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturncodeResponse upVote(int location_id, String deviceId) {
		ReturncodeResponse response = new ReturncodeResponse();

		try {
			Location loc = daoLocation.findById(location_id);
			if (loc == null)
				throw new NoDataException(Messages.NoDataExceptionMsg);

			Device dev = daoDevice.findByDeviceId(deviceId);
			if (dev == null)
				throw new NoDataException(Messages.NoDataExceptionMsg);

			if (daoVote.findByLocationAndDevice(location_id, deviceId) != null)
				throw new MuensterInsideException(123, "Es wurde bereits für diese Location eine Stimme abgegeben!");

			// Transaktion Begin
			Vote vote = new Vote(loc, dev, VoteType.up);
			if (!daoVote.insert(vote))
				throw new NoSavedException(Messages.NoDataExceptionMsg);

			loc.upVote();
			daoLocation.update(loc);

			// Transaktion End

		} catch (MuensterInsideException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}

		return response;
	}

	@Override
	public ReturncodeResponse downVote(int location_id, String deviceId) {
		ReturncodeResponse response = new ReturncodeResponse();

		try {
			Location loc = daoLocation.findById(location_id);
			if (loc == null)
				throw new NoDataException(Messages.NoDataExceptionMsg);

			Device dev = daoDevice.findByDeviceId(deviceId);
			if (dev == null)
				throw new NoDataException(Messages.NoDataExceptionMsg);

			if (daoVote.findByLocationAndDevice(location_id, deviceId) != null)
				throw new MuensterInsideException(123, "Es wurde bereits für diese Location eine Stimme abgegeben!");

			// Transaktion Begin
			Vote vote = new Vote(loc, dev, VoteType.down);
			if (!daoVote.insert(vote))
				throw new NoSavedException(Messages.NoDataExceptionMsg);

			loc.downVote();
			daoLocation.update(loc);

			// Transaktion End

		} catch (MuensterInsideException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}

		return response;
	}

	@Override
	public IsVotedRepsonse isVoted(int location_id, String deviceId) {
		IsVotedRepsonse response = new IsVotedRepsonse();

		Vote vote = daoVote.findByLocationAndDevice(location_id, deviceId);
		if (vote != null) {
			response.setIsVoted(true);
		}

		return response;
	}
}
