<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>입사일</th>
		<th>월급</th>
		<th>직급</th>
		<th>재직여부</th>
	</tr>
	<c:if test="${empty employeeList}">
		<tr>
			<td colspan="3">내용이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items="${employeeList}" var="employee">
		<tr onclick="goView(${employee.emp_no})">
			<td>${employee.emp_no}</td>
			<td>${employee.emp_name}</td>
			<td>${employee.emp_credat}</td>
			<td>${employee.emp_salary}</td>
			<td>${employee.grd_name}</td>
			<td>${employee.emp_active}</td>
		</tr>
	</c:forEach>
</table>
	<script>
		function goView(emp_no){
			location.href='/employee/employee-view?emp_no=' + emp_no;
		}
	</script>
</body>
</html>