package com.erp.test.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	int insertEmployee(Map<String,Object> employee);
	int updateEmployee(Map<String,Object> employee);
	int deleteEmployee(Map<String,Object> employee);
	Map<String,Object> selectEmployee(Map<String,Object> employee);
	List<Map<String,Object>> selectEmployeeList(Map<String,Object> employee);
}
