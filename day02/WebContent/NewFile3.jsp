<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 액션 태그</title>
<!-- 자주 바뀌는 내용에서 사용하는것이 유리 -->
</head>
<body>

<h2>NewFile3.jsp 페이지입니다.</h2>
<hr>
<jsp:include page="footer.jsp">
	<jsp:param value="coding_helper@naver.com" name="email"/>
	<jsp:param value="010-1234-5678" name="tel"/>
</jsp:include>	
<!--  <jsp:include page="footer.jsp" /> 이렇게 짝 없이 쓸수도 있음 -->
<!-- 띄어쓰기 중요! 잘 확인! -->
<!-- 태그 바디가 있음 -->
<!-- include: 제어권을 다시 받아옴 ex)검색 -->

</body>
</html>