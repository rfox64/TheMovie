package com.theater.model;

import java.util.List;

public class TheaterService {
	private TheaterDAO_interface dao;

	public TheaterService() {
		dao = new TheaterDAO();
	}
	public void addTheater(TheaterVO theaVO) {
		dao.insert(theaVO);
	}
	
	public TheaterVO updateTheater(TheaterVO theaVO) {
		dao.update(theaVO);
		return dao.findByPrimaryKey(theaVO.getTheaID());
	}
	
	public TheaterVO getOneTheater(Integer theaID) {
		return dao.findByPrimaryKey(theaID);
	}
	
	public List<TheaterVO> getAll() {
		return dao.getAll();
	}
	public void deleteTheater(Integer theaID) {
		dao.delete(theaID);
	}
}
