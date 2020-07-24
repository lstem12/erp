package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.EmployeeDAO;
import com.erp.test.dao.impl.EmployeeDAOImpl;
import com.erp.test.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	@Override
	public Map<String, Object> insertEmployee(Map<String, Object> employee) {
		Map<String, Object> rMap = new HashMap<>();
		int result = employeeDAO.insertEmployee(employee);
		rMap.put("msg", (result==1)?"사원 추가완료":"사원 추가실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateEmployee(Map<String, Object> employee) {
		Map<String, Object> rMap = new HashMap<>();
		int result = employeeDAO.updateEmployee(employee);
		rMap.put("msg", (result==1)?"사원 수정완료":"사원 수정실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteEmployee(Map<String, Object> employee) {
		Map<String, Object> rMap = new HashMap<>();
		int result = employeeDAO.deleteEmployee(employee);
		rMap.put("msg", (result==1)?"사원 삭제완료":"사원 삭제실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> employee) {
		return employeeDAO.selectEmployee(employee);
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> employee) {
		return employeeDAO.selectEmployeeList(employee);
	}

}
