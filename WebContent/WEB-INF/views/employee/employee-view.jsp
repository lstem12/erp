<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/employee/employee-update" id="frm">
	<input type="hidden" name="emp_no" value="${employee.emp_no}">
	
	<c:if test="${employee.emp_active eq 1 || employee.emp_active eq 2}">
	<table border="1">
		<tr>
			<th>사원번호</th>
			<td>${employee.emp_no}</td>
		</tr>
		<tr>
			<th>사원이름</th>
			<td>${employee.emp_name}</td>
		</tr>
		<tr>
			<th>입사일</th>
			<td>${employee.emp_credat}</td>
		</tr>
		<tr>
			<th>월급</th>
			<td><input type="text" name="emp_salary" value="${employee.emp_salary}"></td>
		</tr>
		<tr>
			<th>직급명</th>
			<td>${employee.grd_name}</td>
		</tr>
		<tr>
			<th>수정직급번호</th>
			<td><input type="text" name="grd_no" value="${employee.grd_no}"></td>
		</tr>
		<tr>
			<th>근무상태</th>
			<td><input type="text" name="emp_active" value="${employee.emp_active}"></td>
		</tr>
		<tr>
			<th colspan="2"><button>수정</button><button type="button" onclick="doDelete()">삭제</button></th>
		</tr>
	</table>
	</c:if>
	<c:if test="${employee.emp_active eq 0 }">
		<script>
			alert('퇴사한 직원입니다.');
			location.href = '/employee/employee-list';
		</script>
	</c:if>
</form>
	<script>
		function doDelete() {
			var formObj = document.querySelector("#frm");
			formObj.action = '/employee/employee-delete';
			formObj.submit();
		}
	</script>
</body>
</html>