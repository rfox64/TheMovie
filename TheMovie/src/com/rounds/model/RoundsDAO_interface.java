package com.rounds.model;

import java.sql.Timestamp;
import java.util.List;

public interface RoundsDAO_interface {
	public void insert(RoundsVO roundVO);
	public void update(RoundsVO roundVO);
	public void delete(Integer roundID);
	public RoundsVO findByPK(Integer roundID);
	public List<RoundsVO> findByMvID(Integer mvID);
	public List<RoundsVO> findByRoomID(Integer roomID);
	public List<RoundsVO> findByDateTime(Timestamp date);
	
}
