<%@page import="model.message.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="memberVO" class="model.member.MemberVO" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 입력 화면</title>
</head>
<body>

<h2>게시글 등록</h2>
<hr>

	<form action="control.jsp" method="post" name="form1">
		<input type="hidden" name="action" value="insert"> <input
			type="hidden" name="id" value="<%= memberVO.getUserID() %>">
		<table>
			<thead>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" required></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>내용</th>
					<td><textarea name="content" required></textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="글 등록" class="button"></td>
				</tr>
			</tfoot>
		</table>
</body>
</html>