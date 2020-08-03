<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div.sido{
	border: 2px solid gray;
	width : 180px;
	text-align : center;
	font-size : 25px;
	float : left;
	margin-left : 10px;
	margin-top : 10px;
}
</style>
</head>
<body>
<div class="sido">전체</div>	
	<c:forEach items="${sidoList}" var="sido" varStatus="idx">
		<c:if test="${fn:contains(sido, '충청') || fn:contains(sido, '경상') || fn:contains(sido, '전라')}">
			<div class="sido">${fn:substring(sido,0,1)}${fn:substring(sido,2,3)}</div>
		</c:if>
			
		<c:if test="${!fn:contains(sido, '충청') && !fn:contains(sido, '경상') && !fn:contains(sido, '전라')}">
			<div class="sido">${fn:substring(sido,0,2)}</div>
		</c:if>
				
		<c:if test="${idx.count==8}">
			<br>
		</c:if> 
	</c:forEach>
	
	<c:forEach items="${gugunList}" var="gugun" varStatus="idx">
		<div class="sido" onclick="gugunList(this)" data-gugun="${gugun}">
			${fn:substring(gugun,0,2)}
		</div>
		<c:if test="${idx.count==8}">
			<br>
		</c:if>
</c:forEach>

<script>
function selectSido(sidoObj){
	var sido = sidoObj.getAttribute('data-sido');
	location.href='/test?sido='+ sido;
}
</script>
</body>
</html>