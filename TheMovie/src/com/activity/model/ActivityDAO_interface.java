package com.activity.model;

import java.util.List;

public interface ActivityDAO_interface {
	public void insert(ActivityVO actVO);
    public void update(ActivityVO actVO);
    public ActivityVO findByPrimaryKey(Integer actID);
    public List<ActivityVO> getAll();
    public void delete(Integer actID);
    public List<ActivityVO> getActTitle();
	
}
