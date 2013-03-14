package com.member.model;

import java.util.*;

public interface MemberDAO_interface {
          public void insert(MemberVO memberVO);
          public void update(MemberVO memberVO);
          public void delete(Integer mbID);
          public MemberVO findByPrimaryKey(Integer mbID);
          public MemberVO findByMobile(String mobile);
          public List<MemberVO> getAll();
}
