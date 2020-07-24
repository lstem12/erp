package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.GradeDAO;
import com.erp.test.dao.impl.GradeDAOImpl;
import com.erp.test.service.GradeService;

public class GradeServiceImpl implements GradeService {
	private GradeDAO gradeDAO = new GradeDAOImpl();
	@Override
	public Map<String, Object> insertGrade(Map<String, Object> grade) {
		Map<String, Object> rMap = new HashMap<>();
		int result = gradeDAO.insertGrade(grade);
		rMap.put("msg", (result==1)?"직급 추가완료":"직급 추가실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateGrade(Map<String, Object> grade) {
		Map<String, Object> rMap = new HashMap<>();
		int result = gradeDAO.updateGrade(grade);
		rMap.put("msg", (result==1)?"직급 수정완료":"직급 수정실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteGrade(Map<String, Object> grade) {
		Map<String, Object> rMap = new HashMap<>();
		int result = gradeDAO.deleteGrade(grade);
		rMap.put("msg", (result==1)?"직급 삭제완료":"직급 삭제실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> selectGrade(Map<String, Object> grade) {
		return gradeDAO.selectGrade(grade);
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		return gradeDAO.selectGradeList(grade);
	}

}
