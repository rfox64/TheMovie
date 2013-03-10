package com.room.model;

import java.util.List;

public interface RoomDAO_interface {
	public void insert(RoomVO roomVO);
    public void update(RoomVO roomVO);
    public RoomVO findByPrimaryKey(Integer roomID);
    public List<RoomVO> getAll();

}
