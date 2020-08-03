package com.erp.test.service.impl;

import java.util.List;

import com.erp.test.dao.SelectAddressDAO;
import com.erp.test.dao.impl.SelectAddressDAOImpl;
import com.erp.test.service.SelectAddressService;

public class SelectAddressServiceImpl implements SelectAddressService {
	private SelectAddressDAO saDao = new SelectAddressDAOImpl();
	@Override
	public List<String> selectSidoList(String sido) {
		return saDao.selectSidoList(sido);
	}

	@Override
	public List<String> selectGugunList(String sido) {
		return saDao.selectGugunList(sido);
	}

	@Override
	public List<String> selectDongList(String sido, String gugun) {
		return saDao.selectDongList(sido, gugun);
	}

}
