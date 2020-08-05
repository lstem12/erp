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
var person = '{"name":"이상화", "age":31, "address":"중랑구", "hobby":"게임"}';
/*
 * 키 : name,age,address,hobby
 */
 person = JSON.parse(person);
 alert(person.name + ',' + person.age + ',' +person.address + ',' +person.hobby);
</script>
</body>
</html>