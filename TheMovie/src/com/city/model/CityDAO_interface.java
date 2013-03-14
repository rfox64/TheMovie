package com.city.model;

import java.util.*;

public interface CityDAO_interface {
          public void insert(CityVO cityVO);
          public void update(CityVO cityVO);
          public void delete(Integer cityID);
          public CityVO findByPrimaryKey(Integer cityID);
          public List<CityVO> getAll();
}
