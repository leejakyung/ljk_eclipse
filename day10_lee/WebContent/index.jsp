<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index 페이지</title>
</head>

<h2>여기는 메인페이지!!!</h2>
<hr>
<br>
<body>
<!-- 
	<form action="control.jsp" method="post" name="form1">
		<input type="hidden" name="action" value="login">
		<input type="submit" value="»로그인하러가기" ><br><br>
		<input type="button" value="»회원가입하러가기" onclick="location.href='signup.jsp'">
	</form> -->
	
	<%pageContext.forward("control.jsp?action=main"); %>


</body>
</html>