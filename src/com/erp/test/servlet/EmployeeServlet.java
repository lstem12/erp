package com.erp.test.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.EmployeeService;
import com.erp.test.service.impl.EmployeeServiceImpl;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService = new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/employee/employee-list".equals(uri)) {
			request.setAttribute("employeeList", employeeService.selectEmployeeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/employee/employee-list");
			rd.forward(request, response);
		}else if("/employee/employee-view".equals(uri)) {
			Map<String, Object> rMap = new HashMap<>();
			rMap.put("emp_no", Integer.parseInt(request.getParameter("emp_no")));
			request.setAttribute("employee", employeeService.selectEmployee(rMap));
			RequestDispatcher rd = request.getRequestDispatcher("/views/employee/employee-view");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		
		if("/employee/employee-insert".equals(uri)) {
			String empName = request.getParameter("emp_name");
			int empSalary = Integer.parseInt(request.getParameter("emp_salary"));
			int grdNo = Integer.parseInt(request.getParameter("grd_no"));
			Map<String, Object> map = new HashMap<>();
			map.put("emp_name", empName);
			map.put("emp_salary", empSalary);
			map.put("grd_no", grdNo);
			Map<String,Object> rMap = employeeService.insertEmployee(map);
			rMap.put("url", "/employee/employee-list");
			request.setAttribute("rMap", rMap);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}else if("/employee/employee-update".equals(uri)) {
			int empNo = Integer.parseInt(request.getParameter("emp_no"));
			int empSalary = Integer.parseInt(request.getParameter("emp_salary"));
			int grdNo = Integer.parseInt(request.getParameter("grd_no"));
			int empActive = Integer.parseInt(request.getParameter("emp_active"));
			Map<String, Object> map = new HashMap<>();
			map.put("emp_no", empNo);
			map.put("emp_salary", empSalary);
			map.put("grd_no", grdNo);
			map.put("emp_active", empActive);
			Map<String,Object> rMap = employeeService.updateEmployee(map);
			rMap.put("url", "/employee/employee-list");
			request.setAttribute("rMap", rMap);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);			
		}else if("/employee/employee-delete".equals(uri)) {
			int empNo = Integer.parseInt(request.getParameter("emp_no"));
			Map<String, Object> map = new HashMap<>();
			map.put("emp_no", empNo);
			Map<String,Object> rMap = employeeService.deleteEmployee(map);
			rMap.put("url", "/employee/employee-list");
			request.setAttribute("rMap", rMap);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}
	}

}
