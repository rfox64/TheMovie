package com.theater.model;

import java.util.List;

public interface TheaterDAO_interface {
	public void insert(TheaterVO theaVO);
    public void update(TheaterVO theaVO);
    public TheaterVO findByPrimaryKey(Integer theaID);
    public List<TheaterVO> getAll();
    public void delete(Integer deptno);
}
