package com.erp.test.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	Map<String,Object> insertEmployee(Map<String,Object> employee);
	Map<String,Object> updateEmployee(Map<String,Object> employee);
	Map<String,Object> deleteEmployee(Map<String,Object> employee);
	Map<String,Object> selectEmployee(Map<String,Object> employee);
	List<Map<String,Object>> selectEmployeeList(Map<String,Object> employee);
}
