package com.rounds.model;

import java.sql.Timestamp;
import java.util.List;

public class RoundsService {
	private RoundsDAO_interface dao;

	public RoundsService() {
		dao = new RoundsDAO();
	}

	public RoundsVO addRound(Integer roomID, Integer mvID, Timestamp roundsDateTime, String seat) {

		RoundsVO roundsVO = new RoundsVO();
		roundsVO.setMvID(mvID);
		roundsVO.setRoomID(roomID);
		roundsVO.setRoundsDateTime(roundsDateTime);
		roundsVO.setSeat(seat);
		
		dao.insert(roundsVO);

		return roundsVO;
	}

	public void addRound(RoundsVO roundsVO) {
		dao.insert(roundsVO);
	}

	public RoundsVO updateRound(Integer roundsID, Integer roomID, Integer mvID, Timestamp roundsDateTime, String seat) {

		RoundsVO roundsVO = new RoundsVO();
		roundsVO.setRoundsID(roundsID);
		roundsVO.setMvID(mvID);
		roundsVO.setRoomID(roomID);
		roundsVO.setRoundsDateTime(roundsDateTime);
		roundsVO.setSeat(seat);
				
		dao.update(roundsVO);

		return dao.findByPrimaryKey(roundsID);
	}

	public RoundsVO updateRound(RoundsVO roundsVO) {
		dao.update(roundsVO);
		return dao.findByPrimaryKey(roundsVO.getRoundsID());
	}

	public RoundsVO getOneRound(Integer roundsID) {
		return dao.findByPrimaryKey(roundsID);
	}

	public List<RoundsVO> getMultiRoundsByMvID(Integer mvID) {
		return dao.findByMvID(mvID);
	}

	public List<RoundsVO> getMultiRoundsByRoomID(Integer roomID) {
		return dao.findByRoomID(roomID);
	}

	public List<RoundsVO> getMultiRoundsByDateTime(Timestamp sDT, Timestamp eDT) {
		return dao.findByDateTime(sDT, eDT);
	}
	
	public List<RoundsVO> getAll() {
		return dao.getAll();
	}

}
