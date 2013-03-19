package com.sales.model;

import java.util.*;

public interface SalesDAO_interface {
          public void insert(SalesVO salesVO);
          public void update(SalesVO salesVO);
          public void delete(Integer salesID);
          public SalesVO findByPrimaryKey(Integer salesID);
          public SalesVO loginAccount(String account);
          public List<SalesVO> getAll();
}
