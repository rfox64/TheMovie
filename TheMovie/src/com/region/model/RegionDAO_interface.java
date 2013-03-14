package com.region.model;

import java.util.*;

public interface RegionDAO_interface {
          public void insert(RegionVO regionVO);
          public void update(RegionVO regionrVO);
          public void delete(Integer regionID);
          public RegionVO findByPrimaryKey(Integer regionID);
          public List<RegionVO> getAll();
}
