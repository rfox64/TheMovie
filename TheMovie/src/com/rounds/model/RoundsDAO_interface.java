package com.rounds.model;

import java.sql.Timestamp;
import java.util.List;

public interface RoundsDAO_interface {
	public void insert(RoundsVO roundsVO);
	public void update(RoundsVO roundsVO);
	public void delete(Integer roundsID);
	public RoundsVO findByPrimaryKey(Integer roundsID);
	public List<RoundsVO> findByMvID(Integer mvID);
	public List<RoundsVO> findByRoomID(Integer roomID);
	public List<RoundsVO> findByDateTime(Timestamp startDateTime, Timestamp endDateTime);
	public List<RoundsVO> getAll();
}
