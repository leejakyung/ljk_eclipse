<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기 들어가면 jar파일 다운로드 가능! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>&lt;c:forEach&gt;실습</h1>
	<hr>

	<table border="1">
		<c:forEach var="v" items="${members}">
			<tr>
				<td>${v.name}</td>
				<td><c:out value="${v.email}" escapeXml="false"><font color="red">email 정보없음</font></c:out></td> 
				<!-- c:out은 뭔가를 출력하는데 쓰임 -> 잘안씀! (만약에 정보가 없다면 이렇게 띄워줘 할때정도 쓰임) -->
				<!-- c:out의 속성: escapeXml="false" -->
			</tr>
		</c:forEach>
	</table>




</body>
</html>