<%@page import="model.message.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="memData" class="model.member.MemberVO" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정/삭제</title>
<script type="text/javascript">
	function memDel() {
		result = confirm("회원탈퇴를 진행하시겠습니까?");
		if (result == true) {
			document.form1.action.value = "deleteMem"; // form1의 action 파라미터를 delete로 설정
			document.form1.submit();
		} else {
			return;
		}
	}
</script>
</head>
<body>

	<h2>My Page</h2>
	<hr>

		<form action="control.jsp" method="post" name="form1">
			<input type="hidden" name="action" value="updateMem"> 
			<input type="hidden" name="userID" value="<%= memData.getUserID() %>">
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<td><input type="text" name="userID"
							value="<%= memData.getUserID() %>"></td>
					</tr>
					<tr>
						<th>PW</th>
						<td><input type="text" name="userPW"
							value="<%= memData.getUserPW() %>"></td>
					</tr>
					<tr>
						<th>NAME</th>
						<td><input type="text" name="name"
							value="<%= memData.getName() %>"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" align="right"><input type="submit"
							value="회원정보 수정" class="button" > <input type="button"
							value="회원탈퇴" class="button" onclick="memDel()"> <input
							type="button" value="메인으로"
							onclick="location.href='control.jsp?action=list'"></td>
					</tr>
				</tfoot>
			</table>
		</form>
</body>
</html>