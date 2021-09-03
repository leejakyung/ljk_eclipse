<%@ tag language="java" pageEncoding="UTF-8"%>

<%
	if(session.getAttribute("mem")!=null){
%>
${mem.userID}님, 환영합니다! <hr>
	<form action="control.jsp" method="post" name="form1">
		<input type="hidden" name="action" value="logout">
		<input type="submit" value="로그아웃">
	</form>
<%
	}
%>