package com.erp.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.GradeService;
import com.erp.test.service.impl.GradeServiceImpl;

public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GradeService gradeService = new GradeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if ("/grade/grade-list".equals(uri)) {
			request.setAttribute("gradeList", gradeService.selectGradeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade-list");
			rd.forward(request, response);
		}else if ("/grade/grade-view".equals(uri)) {
			String grd_no = request.getParameter("grdNo");
			int grdNo = Integer.parseInt(grd_no);
			Map<String,Object> map = new HashMap<>();
			map.put("grd_no", grdNo);
			if (grd_no == null || "".equals(grd_no.trim())) {
				throw new ServletException("나가");
			}
			request.setAttribute("grade", gradeService.selectGrade(map));
			
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade-view");
			rd.forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int grdNo = Integer.parseInt(request.getParameter("grd_no"));
		String grdName = request.getParameter("grd_name");
		String grdDesc = request.getParameter("grd_desc");	
		
		if ("/grade/grade-insert".equals(uri)) {
			Map<String, Object> grade = new HashMap<>();
			grade.put("grd_no", grdNo);
			grade.put("grd_name", grdName);
			grade.put("grd_desc", grdDesc);
			gradeService.insertGrade(grade);

			
		}else if ("/grade/grade-update".equals(uri)) {
			Map<String, Object> grade = new HashMap<>();
			grade.put("grd_no", grdNo);
			grade.put("grd_name", grdName);
			grade.put("grd_desc", grdDesc);
			Map<String, Object> rMap = gradeService.updateGrade(grade);
			rMap.put("url", "/grade/grade-list");
			request.setAttribute("rMap", rMap);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}
		else if ("/grade/grade-delete".equals(uri)) {
			Map<String, Object> grade = new HashMap<>();
			grade.put("grd_no", grdNo);

		}
			
	}

}
