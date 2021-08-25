<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 액션 태그2</title>
<!-- 자주 바뀌는 내용에서 사용하는것이 유리 -->
</head>
<body>

<h2>NewFile4.jsp 페이지입니다.</h2>
<hr>
<jsp:forward page="footer.jsp">
	<jsp:param value="coding_helper@naver.com" name="email"/>
	<jsp:param value="010-1234-5678" name="tel"/>
</jsp:forward>	
<!-- forward: 주도권을 넘긴 상태로 다시 받아오지 않음 -->
<!-- 무언가 정보를 넘기고 다시 받아오지 않아도 될 때 씀! -->


</body>
</html>