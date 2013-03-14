package com.member.model;

import java.sql.Date;
import java.util.List;

//import com.city.model.CityVO;

public class MemberService {

	private MemberDAO_interface dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	public MemberVO addEmp(Integer mbID, String firstName, String lastName,
			Integer cityID, Integer regionID, String address, String mobile,
			Date birthday, Integer gender, Integer proID, Integer eduID,
			String email, String password, Integer activation,
			Date inactivationD) {

		MemberVO memberVO = new MemberVO();

		memberVO.setMbID(mbID);
		memberVO.setFirstName(firstName);
		memberVO.setLastName(lastName);
		// CityVO cityVO = new CityVO();
		// cityVO.setCityID(cityID);
		memberVO.setCityID(cityID);
		memberVO.setRegionID(regionID);
		memberVO.setAddress(address);
		memberVO.setMobile(mobile);
		memberVO.setBirthday(birthday);
		memberVO.setGender(gender);
		memberVO.setProID(proID);
		memberVO.setEduID(eduID);
		memberVO.setEmail(email);
		memberVO.setPassword(password);
		memberVO.setActivation(activation);
		memberVO.setInactivationD(inactivationD);

		dao.insert(memberVO);

		return memberVO;
	}

	// �w�d�� Struts 2 �Ϊ�
	public void addMember(MemberVO memberVO) {
		dao.insert(memberVO);
	}

	public MemberVO updateMember(Integer mbID, String firstName,
			String lastName, Integer cityID, Integer regionID, String address,
			String mobile, Date birthday, Integer gender, Integer proID,
			Integer eduID, String email, String password, Integer activation,
			Date inactivationD) {

		MemberVO memberVO = new MemberVO();

		memberVO.setMbID(mbID);
		memberVO.setFirstName(firstName);
		memberVO.setLastName(lastName);
		// CityVO cityVO = new CityVO();
		// cityVO.setCityID(cityID);
		memberVO.setCityID(cityID);
		memberVO.setRegionID(regionID);
		memberVO.setAddress(address);
		memberVO.setMobile(mobile);
		memberVO.setBirthday(birthday);
		memberVO.setGender(gender);
		memberVO.setProID(proID);
		memberVO.setEduID(eduID);
		memberVO.setEmail(email);
		memberVO.setPassword(password);
		memberVO.setActivation(activation);
		memberVO.setInactivationD(inactivationD);
		dao.update(memberVO);

		return dao.findByPrimaryKey(mbID);
	}

	// �w�d�� Struts 2 �Ϊ�
	public MemberVO updateMember(MemberVO memberVO) {
		dao.update(memberVO);
		return dao.findByPrimaryKey(memberVO.getMbID());
	}

	public void deleteMember(Integer MbID) {
		dao.delete(MbID);
	}

	public MemberVO getOneMember(Integer mbID) {
		return dao.findByPrimaryKey(mbID);
	}

	public MemberVO getOneMember(String mobile) {
		return dao.findByMobile(mobile);
	}
	
	public List<MemberVO> getAll() {
		return dao.getAll();
	}

}
