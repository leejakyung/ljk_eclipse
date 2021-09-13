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
	<li><a href="control.jsp?action=main">전체목록보기</a></li>
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

</body>
</html>