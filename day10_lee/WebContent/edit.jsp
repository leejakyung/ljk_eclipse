<%@page import="model.message.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="data" class="model.message.MessageVO" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정/삭제</title>
<script type="text/javascript">
	function del() {
		result = confirm("정말로 삭제하시겠습니까?");
		if (result == true) {
			document.form1.action.value = "delete"; // form1의 action 파라미터를 delete로 설정
			document.form1.submit();
		} else {
			return;
		}
	}
</script>
</head>
<body>

	<h2>게시글 수정</h2>
	<hr>

		<form action="control.jsp" method="post" name="form1">
			<input type="hidden" name="action" value="update"> <input
				type="hidden" name="mnum" value="<%= data.getMnum() %>"> <input
				type="hidden" name="mnum" value="<%= data.getUserID() %>">
			<table>
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"
							value="<%= data.getTitle() %>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><input type="text" name="content"
							value="<%= data.getContent() %>"></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td><input type="date" name="date"
							value="<%= data.getWdate() %>"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" align="right"><input type="submit"
							value="내용 수정" class="button"> <input type="button"
							value="글 삭제" class="button" onclick="del()"> <input
							type="button" value="메인으로"
							onclick="location.href='control.jsp?action=list'"></td>
					</tr>
				</tfoot>
			</table>
		</form>
</body>
</html>