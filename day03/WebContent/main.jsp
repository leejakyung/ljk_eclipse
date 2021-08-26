<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ㅁㅁ 쇼핑몰 페이지</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8"); // 한글 번역
	session.setAttribute("username", request.getParameter("username"));
	// 유지보수: 간은 의미, 같은 값을 가지고 있다면 -> 변수명을 일치시킨다!
	// 앞은 바꿔도 되지만 뒤는 저걸로 무조건 그치만 맞춰줘야함!
	// 설계 -> 변수명 정의, 주석
	// 브라우저를 끄면 새로 나오게 하기 위해 session을 씀
	// setAttribute -> 다음 페이지에 로그인 정보를 가져가지 위해 씀 
%>

<%= session.getAttribute("username") %>님 환영합니다! <br>

<h2>===상품목록===</h2>
<form action="addProduct.jsp" name="form1" method="post">
	<select name="product">
		<option>셔츠</option>
		<option>블라우스</option>
		<option selected="selected">반팔티</option>
		<option>청바지</option>
		<option>운동화</option>
	</select>
	<input type="submit" value="상품 추가하기">

</form>
<hr>
<a href="buy.jsp">구매하기</a>
</body>
</html>