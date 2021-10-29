<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.comments.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 메인화면</title>
<%-- <script type="text/javascript">
	function check(mnum, userID) {
		if(userID == '<%=client2VO.getUserID()%>'){
			document.location.href = "control.jsp?action=edit&mnum=" + mnum;
		} else {
			alert("접근 권한이 없습니다!");
		}
	}
</script> --%>
</head>
<body>
<c:if test="${seUser!=null}">
	${seUser.userID}님 환영합니다😎 <hr>
	<form action="logout.do" method="post" name="form2">

		<input type="submit" value="로그아웃">
	</form>
</c:if>
<h2 style="color: skyblue;">게시글</h2>
<hr>

<table>
	<tr>
		<th>글 번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
<c:if test="${mdatas==null}">
	<tr>
		<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
	</tr>
</c:if>

<c:if test="${mdatas!=null}">
<c:forEach var="v" items="${mdatas}">
<tr>
	<td>${v.mnum}</td>
	<td>
	<c:if test="${seUser.userID==v.userID}">
	<a href="edit.do?mnum=${v.mnum}">${v.title}</a>
	</c:if>
	<c:if test="${seUser.userID!=v.userID}">
	${v.title}
	</c:if>
	
	</td>
	<td>${v.userID}</td>
	<td>${v.wdate}</td>
</tr>
</c:forEach>
</c:if>

</table>
<form action="" method="post" name="form1">
	<table>
		<tr>
			<td colspan="2" align="right"><input type="button" value="내 글보기" class="button" onclick="location.href='list.do?isMine=true'"></td>
			<td colspan="2" align="right"><input type="button" value="글 작성하기" class="button" onclick="location.href='form.jsp'"></td>
		</tr>
	</table>
	<a href="mypage.jsp" >마이페이지</a>
</form>	
	
</body>
</html>