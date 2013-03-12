package com.activity.model;

import java.util.List;

public class ActivityService {
	private ActivityDAO_interface dao;
	public ActivityService(){
		dao = new ActivityDAO();
	}
	public void addActivity(ActivityVO actVO){
		dao.insert(actVO);
	}
	public ActivityVO updateActivity(ActivityVO actVO){
		dao.update(actVO);
		return dao.findByPrimaryKey(actVO.getActID());
	}
	public ActivityVO getOneActivity(Integer actID){
		return dao.findByPrimaryKey(actID);
	}
	public List<ActivityVO> getAll(){
		return getAll();
	}
	public void deleteActivity(Integer actID){
		dao.delete(actID);
	}
	public List<ActivityVO> getActTitle(){
		return dao.getActTitle();
	}
}
