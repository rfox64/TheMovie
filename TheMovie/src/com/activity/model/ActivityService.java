package com.activity.model;

import java.sql.Date;
import java.util.List;

public class ActivityService {
	private Activity_interface dao;
	public ActivityService(){
		dao = new ActivityDAO();
	}
//	public ActivityVO addActivity(Integer actID,String actTitle,
//			String summary,Date startDateTime,Date endDateTime){
//		ActivityVO actVO = new ActivityVO();
//		actVO.setActID(actID);
//		actVO.setActTitle(actTitle);
//		actVO.se
//		
//		
//		return null;
//		
//	}
	public void addActivity(ActivityVO actVO){
		dao.insert(actVO);
		System.out.println("hahah");
	}
	public ActivityVO getOneActivity(Integer actID){
		return dao.findByPrimaryKey(actID);
	}
	public ActivityVO updateActivtiy(ActivityVO actVO){
		dao.update(actVO);
		return dao.findByPrimaryKey(actVO.getActID());
	}
	public List<ActivityVO> getAll(){
		return dao.getAll();
	}
	public void deleteActivity(Integer actID){
		dao.delete(actID);
	}
	
	
}
