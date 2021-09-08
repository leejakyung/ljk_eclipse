<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.comment.*,java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="session" />
<jsp:useBean id="commentVO" class="model.comment.CommentVO" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 조회/검색</title>
<script type="text/javascript">
	function check(rpk, rid) {
		if (rid == '<%=commentVO.getRid()%>')
	 {
			document.location.href = "control.jsp?action=edit&rpk=" + rpk;
		} else {
			alert("접근 권한이 없습니다!");
		}
	}

</script>
</head>
<body>
	<h2>REVIEW</h2>
	<hr>

	<table>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
		<%
			if(datas.size()==0){
		%>
		<tr>
			<td colspan="5" align="center">검색 결과가 없습니다.</td>
		</tr>
		<%
			} else{
				for(CommentVO vo : (ArrayList<CommentVO>) datas) {
			
		%>
		<tr>
			<td><%=vo.getRpk()%></td>
			<td><a href="javascript:check(<%=vo.getRpk()%>,'<%=vo.getRid()%>')"><%=vo.getReview()%></a></td>
			<td><%=vo.getRid()%></td>
			<td><%=vo.getRdate()%></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	
	<form action="control.jsp" name="form1">
		<input type="hidden" name="action" value="list">
		<table>
			<tr>
				<td><input type="button" value="내가 쓴 리뷰보기" class="button" onclick="location.href='control.jsp?action=mylist'"></td>
				<td><input type="button" value="리뷰쓰기" class="button" onclick="location.href='reviewForm.jsp'"> </td>
			</tr>
		</table>
	</form>
</body>
</html>