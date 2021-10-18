<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 내장객체-실습</title>
</head>
<body>

	<%
		if (session.isNew()) { // 세션이 새거니? (isnew를 없애면  null 값 해결)
			out.println("<script>alert('로그인 됨!')</script>");
			request.setCharacterEncoding("UTF-8"); // 한글 번역
			session.setAttribute("userid", request.getParameter("userid"));
			session.setMaxInactiveInterval(5); // 5초
			// coding_helper 라는 사람이
			// user 라는 변수명(이름)으로 등록됨
			// 세션단위로 등록됨!
			// == 브라우저가 종료되지 앟는 한, 사라지지 않음!
			// == 시간개념, 30분 (==1800초)
		}
		
	%>


	<%=session.getAttribute("userid")%>님, 환영합니다!
	<br>
	<%=session.getMaxInactiveInterval()%>
	초 동안 세션정보가 유지됩니다.
	<br>



	<a href="riot.jsp">라이엇님의 미니홈피</a>

</body>
</html>