package com.sales.model;

import java.util.*;

public interface SalesDAO_interface {
          public void insert(SalesVO salesVO);
          public void update(SalesVO salesVO);
          public SalesVO findByPrimaryKey(Integer salesID);
          public List<SalesVO> getAll();
}


