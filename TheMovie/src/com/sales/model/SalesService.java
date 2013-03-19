package com.sales.model;

import java.util.List;


public class SalesService {

	private SalesDAO_interface dao;

	public SalesService() {	
		dao = new SalesDAO();
		}

	public SalesVO addSales(Integer salesID, String salesName, String account,
			String password, String theaID, Integer activation){

		SalesVO salesVO = new SalesVO();

		salesVO.setSalesName(salesName);
		salesVO.setAccount(account);
		salesVO.setPassword(password);
		salesVO.setTheaID(theaID);
		salesVO.setActivation(activation);
		dao.insert(salesVO);

		return salesVO;
	}

	public void addSales(SalesVO salesVO) {
		dao.insert(salesVO);
	}

	public SalesVO updateSales(Integer salesID, String salesName,
			String account, String password, String theaID, Integer activation) {

		SalesVO salesVO = new SalesVO();

		salesVO.setSalesID(salesID);
		salesVO.setSalesName(salesName);
		salesVO.setAccount(account);
		salesVO.setPassword(password);
		salesVO.setTheaID(theaID);
		salesVO.setActivation(activation);
		
		dao.update(salesVO);

		return dao.findByPrimaryKey(salesID);
	}


	public SalesVO updateSales(SalesVO salesVO) {
		dao.update(salesVO);
		return dao.findByPrimaryKey(salesVO.getSalesID());
	}

	public void deleteSales(Integer salesID) {
		dao.delete(salesID);
	}

	public SalesVO getOneSales(Integer salesID) {
		return dao.findByPrimaryKey(salesID);
	}
	
//	登錄
	public SalesVO getOneAccount(String account) {
		return dao.loginAccount(account);
	}

	public List<SalesVO> getAll() {
		return dao.getAll();
	}
}
