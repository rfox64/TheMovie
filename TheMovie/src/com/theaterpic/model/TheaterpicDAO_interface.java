package com.theaterpic.model;

import java.util.List;

import com.theater.model.TheaterVO;

public interface TheaterpicDAO_interface {
	public void insert(TheaterpicVO theapicVO);
    public void update(TheaterpicVO theapicVO);
    public TheaterpicVO findByPrimaryKey(Integer theaPicID);
    public List<TheaterpicVO> getAll();
    public void delete(Integer theapicID);
}
