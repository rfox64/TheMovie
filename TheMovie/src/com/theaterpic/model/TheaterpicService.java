package com.theaterpic.model;

import java.util.List;

import com.theater.model.TheaterVO;

public class TheaterpicService {
	private TheaterpicDAO_interface dao;
	
	public TheaterpicService(){
		dao = new TheaterpicDAO();
	}
	public void addTheaterpic(TheaterpicVO theapicVO){
		dao.insert(theapicVO);
	}
	public TheaterpicVO updateTheaterpic(TheaterpicVO theapicVO) {
		dao.update(theapicVO);
		return dao.findByPrimaryKey(theapicVO.getTheaID());
	}
	public TheaterpicVO getOneTheaterpic(Integer theaPicID) {
		return dao.findByPrimaryKey(theaPicID);
	}
	
	public List<TheaterpicVO> getAll() {
		return dao.getAll();
	}
	public void deleteTheaterpic(Integer theaPicID) {
		dao.delete(theaPicID);
	}
}
