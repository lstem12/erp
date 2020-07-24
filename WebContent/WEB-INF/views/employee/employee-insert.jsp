<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/employee/employee-insert">
사원이름 : <input type="text" name="emp_name" value="${employee.emp_name}"><br>
사원월급 : <input type="text" name="emp_salary" value="${employee.emp_salary}"><br>
사원직급 : <input type="text" name="grd_no" value="${employee.grd_no}"><br>
<button>사원정보 입력</button>
</form>
</body>
</html>