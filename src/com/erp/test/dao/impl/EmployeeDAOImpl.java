package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Conn;
import com.erp.test.dao.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int insertEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "insert into employee(emp_no, emp_name, emp_credat, emp_salary, grd_no)\r\n" + 
					"values(seq_employee_emp_no.nextval, ?, sysdate,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, employee.get("emp_name").toString());
			ps.setInt(2, (int) employee.get("emp_salary"));
			ps.setInt(3, (int) employee.get("grd_no"));
			result = ps.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conn.close(ps, con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int updateEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "update employee set emp_salary=?, grd_no=?, emp_active=? where emp_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int) employee.get("emp_salary"));
			ps.setInt(2, (int) employee.get("grd_no"));
			ps.setInt(3, (int) employee.get("emp_active"));
			ps.setInt(4, (int) employee.get("emp_no"));
			result = ps.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conn.close(ps, con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int deleteEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "delete from employee where emp_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int) employee.get("emp_no"));
			result = ps.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conn.close(ps, con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = Conn.open();
			String sql = "select e.*, g.grd_name\r\n" + 
					"from employee e, grade g where e.grd_no=g.grd_no and e.emp_no=? ORDER by e.emp_name";
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int) employee.get("emp_no"));
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String, Object> rMap = new HashMap<>();
				rMap.put("emp_no", rs.getInt("emp_no"));
				rMap.put("emp_name", rs.getString("emp_name"));
				rMap.put("emp_credat", rs.getString("emp_credat"));
				rMap.put("emp_salary", rs.getInt("emp_salary"));
				rMap.put("emp_active", rs.getInt("emp_active"));
				rMap.put("grd_name", rs.getString("grd_name"));
				rMap.put("grd_no", rs.getInt("grd_no"));
				return rMap;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conn.close(rs,ps,con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> employee) {
		List<Map<String,Object>> employeeList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = Conn.open();
			String sql = "select e.*, g.grd_name\r\n" + 
					"from employee e, grade g where e.grd_no=g.grd_no ORDER by e.emp_name";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Map<String, Object> map = new HashMap<>();
				map.put("emp_no", rs.getInt("emp_no"));
				map.put("emp_name", rs.getString("emp_name"));
				map.put("emp_credat", rs.getString("emp_credat"));
				map.put("emp_salary", rs.getInt("emp_salary"));
				map.put("emp_active", rs.getInt("emp_active"));
				map.put("grd_name", rs.getString("grd_name"));
				map.put("grd_no", rs.getInt("grd_no"));
				employeeList.add(map);
			}
			return employeeList;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conn.close(rs,ps,con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}	

}
