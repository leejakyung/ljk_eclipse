<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="uVO" class="model.user.UserVO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function del(mid, mcnt) { 
		result = confirm("정말로 삭제하시겠습니까?");
		if (result == true) {
			document.location.href = "control.jsp?action=delete&mid=" + mid+"&mcnt=" +mcnt;
		} else {
			alert("접근 권한이 없습니다!");
		}
	}
	
	function rdel(rid, mcnt) { 
		result = confirm("정말로 삭제하시겠습니까?");
		if (result == true) {
			document.location.href = "control.jsp?action=Rdelete&rid=" + rid+"&mcnt=" +mcnt;
		} else {
			alert("접근 권한이 없습니다!");
		}
	}

</script>
</head>
<body>

<ol>
	<li><a href="control.jsp?action=mainAll">전체목록보기</a></li>
</ol>
<hr>
<a href="control.jsp?action=main&mcnt=${mcnt+1}&selUser=${selUser}">더보기&gt;&gt;</a>

<hr>

<h2>전체목록</h2>
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>[${m.userID}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.mdate}]
	
	
	<c:if test="${seUser == m.userID}">
	<input type="button" value="삭제" onclick="del(${m.mid},${mcnt})"> <!-- 스크립트에 받아온 인자를 넣어줌  -->
	</c:if>
	</h3>
	
	<c:if test="${seUser != null}">
	<form method="post" action="control.jsp">
		<input type="hidden" name="action" value="newrmsg">
		<input type="hidden" name="mid" value ="${m.mid}">
		<input type="hidden" name="userID" value="${seUser}">
		<input type="hidden" name="mcnt" value="${mcnt}"> 
		<input type="text" name="rmsg" required>
		<input type="submit" value="+">
	</form>
</c:if>
<c:if test="${seUser == null}">
	<input type="text" size="25" disabled value="로그인이 필요한 서비스입니다!">
</c:if>
	<!-- select = selUser , session = seUser -->
	<!-- 위에것 구분할 것 !!  -->
	<ol><c:forEach  var="r" items="${v.rlist}">
		<li>${r.userID} >> ${r.rmsg} [${r.rdate}]
		<c:if test="${seUser == r.userID}">
		<input type="button" value="-" onclick="rdel(${r.rid},${mcnt})">
		</c:if>
		</li>
	</c:forEach></ol>
</c:forEach>




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