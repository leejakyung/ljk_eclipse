<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<ol>
	<li><a href="control.jsp?action=mainAll">전체목록보기</a></li>
</ol>

<hr>

<h2>전체목록</h2>
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>[${m.userID}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.mdate}]</h3>
	<ol><c:forEach  var="r" items="${v.rlist}">
		<li>${r.userID} >> ${r.rmsg} [${r.rdate}]</li>
	</c:forEach></ol>
</c:forEach>

<hr>

<a href="control.jsp?action=main&mcnt=${mcnt+1}&selUser=${selUser}">더보기&gt;&gt;</a>

<hr>

<c:if test="${seUser != null}">
	<form method="post" action="control.jsp">
		<input type="hidden" name="action" value="newmsg">
		<input type="hidden" name="userID" value="${seUser}">
		<input type="hidden" name="mcnt" value="${mcnt}"> 
		<textarea name="msg" required></textarea>
		<input type="submit" value="댓글 추가">
	</form>
</c:if>
<c:if test="${seUser == null}">
	<input type="text" size="25" disabled value="로그인이 필요한 서비스입니다!">
</c:if>

<hr>

<a href="insertUser.jsp">회원가입</a> <br>
<form action="control.jsp" method="post">
<input type="hidden" name="mcnt" value="${mcnt}">
<c:choose>
	<c:when test="${empty seUser}">
		<input type="hidden" name="action" value="login">
		<input type="text" name="userID">
		<input type="password" name="upw">
		<input type="submit" value="로그인">  
	</c:when>
	<c:otherwise>
		${seUser}님, 환영합니다!
		<input type="hidden" name="action" value="logout">
		<input type="submit" value="로그아웃">
		<a href="control.jsp?action=main&selUser=${seUser}">내글보기</a>
	</c:otherwise>
</c:choose>
</form>

</body>
</html>