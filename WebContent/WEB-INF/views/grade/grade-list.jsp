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
		<th>직급번호</th>
		<th>직급</th>
		<th>비고</th>
	</tr>
	<c:if test="${empty gradeList}">
		<tr>
			<td colspan="3">내용이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items="${gradeList}" var="grade">
		<tr>
			<td>${grade.grd_no}</td>
			<td><a href="/views/grade?grd_no=${grade.grd_no}">${grade.grd_name}</a></td>
			<td>${grade.grd_desc}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>