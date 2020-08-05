<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function getAjax(){

	var xhr = new XMLHttpRequest();
		//alert(xhr.readyState);
		xhr.open('GET', '/ajax');
		//alert(xhr.readyState);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				alert(xhr.responseText);
			}
		}
		xhr.send();
	}
</script>
<button onclick="getAjax()">클릭</button>
</body>
</html>