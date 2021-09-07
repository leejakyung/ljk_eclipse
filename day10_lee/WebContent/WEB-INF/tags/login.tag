<%@ tag language="java" pageEncoding="UTF-8"%>

<%
	if(session.getAttribute("mem")==null){
%>
<form action="control.jsp" method="post" name="form1">
	<input type="hidden" name="action" value="login">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userID"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPW"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="로그인"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="button" value="»회원가입하러가기" onclick="location.href='signup.jsp'"></td>
		</tr>
		
	</table>

</form>
<%
	}

%>