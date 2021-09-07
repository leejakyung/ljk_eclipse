<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message.*, java.util.*"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
	request.setCharacterEncoding("UTF-8");
%>    
<jsp:useBean id="datas" class="java.util.ArrayList" scope="session" />
<jsp:useBean id="memberVO" class="model.member.MemberVO" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if (session.getAttribute("mem") == null) {
	%>
	<mytag:login />
	<%
		}

		else {
	%>
	<mytag:logout />
	<%
		}
	%>
	
	<br><br>
	
	<h2>게시글</h2>
	<hr>

	<table border="1">

		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>

		<%
			if (datas.size() == 0) {
		%>
		<tr>
			<td colspan="5" align="center">검색 결과가 없습니다.</td>
		</tr>
		<%
			} else {
		/*	for (MessageVO vo : (ArrayList<MessageVO>) datas) { // useBean class 속성에서 제네릭을 사용하지 않았기 때문에 캐스팅 필요! */
		%>
	<%-- 	<tr>
			<!-- 글 번호 클릭 시 상세페이지로 이동 -->
			<!-- 파라미터로 edit과 mnum 넘겨주기 -->
			<td><a href="control.jsp?action=edit&mnum=<%=vo.getMnum()%>"><%=vo.getMnum()%></a></td>
			<td><%=vo.getMnum()%></td>
			<!-- 글 변경을 위한 비밀번호 확인 등의 인증작업 처리 필요! 지금은 없음 -->
			<td><a
				href="javascript:check(<%=vo.getMnum()%>,'<%=vo.getUserID()%>')"><%=vo.getTitle()%></a></td>
			<td><%=vo.getUserID()%></td>
			<td><%=vo.getWdate()%></td>
		</tr> --%>
		<c:forEach var="v" items="${datas}">
			<tr>
				<td>${v.mnum}</td>
				<td>${v.title}</td>
				<td>${v.userID}</td>
				<td>${v.wdate}</td>
			</tr>		
		</c:forEach>
		<%
			}
			
			
		%>
	</table>

	
	
		


</body>
</html>