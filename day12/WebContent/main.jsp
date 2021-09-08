<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.comment.*, java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="session" />
<jsp:useBean id="commentVO" class="model.comment.CommentVO"
	scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼과 리뷰목록 보여주기</title>
</head>
<body>

<%
	if(session.getAttribute("mem")==null){
%>
<form action="control.jsp" method="post" name="form1">
	<input type="hidden" name="action" value="login">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="rid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="rpw"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="로그인"></td>
		</tr>
		
	</table>

</form>
<%
	} else{
%>
${mem.rid}님, 환영합니다! <hr> 
	<form action="control.jsp" method="post" name="form1">
		<input type="hidden" name="action" value="logout">
		<input type="submit" value="로그아웃">
 	</form>
<%
	}
%>

	<br>
	<br>

	<h2>REVIEW</h2>
	<hr>

	<table border="1">

		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>내용</th>
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
				for (CommentVO vo : (ArrayList<CommentVO>) datas) {
		%>
		<tr>
			<!-- 글 번호 클릭 시 상세페이지로 이동 -->
			<!-- 파라미터로 edit과 rpk 넘겨주기 -->
			<td><%=vo.getRpk()%></td>
			<td><%=vo.getRid()%></td>
			<td><%=vo.getReview()%></td>
			<td><%=vo.getRdate()%></td>
		</tr>

		<%
				}
			}
		%>
	</table>


</body>
</html>