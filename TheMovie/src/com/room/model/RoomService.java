package com.room.model;

import java.util.List;

public class RoomService {
	private RoomDAO_interface dao;

	public RoomService() {
		dao = new RoomDAO();
	}

	public RoomVO addRoom(Integer theaID, String roomName, Integer seatTotalRow, Integer seatTotalColumn) {

		RoomVO roomVO = new RoomVO();

		//roomVO.setRoomID(roomID);
		roomVO.setTheaID(theaID);
		roomVO.setSeatTotalRow(seatTotalRow);
		roomVO.setSeatTotalColumn(seatTotalColumn);
		
		dao.insert(roomVO);

		return roomVO;
	}

	//Struts 2
	public void addEmp(RoomVO roomVO) {
		dao.insert(roomVO);
	}

	public RoomVO updateRoom(Integer roomID, Integer theaID, String roomName, Integer seatTotalRow, Integer seatTotalColumn) {

		RoomVO roomVO = new RoomVO();

		roomVO.setRoomID(roomID);
		roomVO.setTheaID(theaID);
		roomVO.setSeatTotalRow(seatTotalRow);
		roomVO.setSeatTotalColumn(seatTotalColumn);
		
		dao.update(roomVO);

		return dao.findByPrimaryKey(roomID);
	}

	// Struts 2
	public RoomVO updateRoom(RoomVO roomVO) {
		dao.update(roomVO);
		return dao.findByPrimaryKey(roomVO.getRoomID());
	}


	public RoomVO getOneRoom(Integer roomID) {
		return dao.findByPrimaryKey(roomID);
	}

	public List<RoomVO> getAll() {
		return dao.getAll();
	}

}
