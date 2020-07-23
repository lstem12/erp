<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/grade/grade-update" id="frm">
<input type="hidden" name="grd_no" value="${grade.grd_no}">
<table border="1">
	<tr>
		<th>직급번호</th>
		<td>${grade.grd_no}</td>
	</tr>
	<tr>
		<th>직급</th>
		<td><input type="text" name="grd_name" value="${grade.grd_name}"></td>
	</tr>
	<tr>
		<th>직급내용</th>
		<td><input type="text" name="grd_desc" value="${grade.grd_desc}"></td>
	</tr>
	<tr>
		<th colspan="2"><button>수정</button><button type="button" onclick="doDelete()">삭제</button></th>
	</tr>	
</table>
</form>
<script>
	function doDelete(){
		var formObj = document.querySelector("#frm");
		formObj.action = '/grade/grade-delete';
		formObj.submit();
	}
</script>
</body>
</html>