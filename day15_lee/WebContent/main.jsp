<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<jsp:useBean id="uVO" class="model.user.UserVO" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function newUser(){
		window.open("insertUser.jsp","회원가입","width=500,height=200");
	}
	
	function del(mid, mcnt) { 
		result = confirm("정말로 삭제하시겠습니까?");
		if (result == true) {
			document.location.href = "control.jsp?action=delete&mid=" + mid+"&mcnt=" +mcnt;
		} else {
			return;
		}
	}
	
	function rdel(rid, mcnt) { 
		result = confirm("정말로 삭제하시겠습니까?");
		if (result == true) {
			document.location.href = "control.jsp?action=Rdelete&rid=" + rid+"&mcnt=" +mcnt;
		} else {
			return;
		}
	}

</script>
</head>
<body>

<div class="content">
<ol>
	<li><a href="control.jsp?action=mainAll"><img alt="로고" src="image/pig.png" style="width:100px;height:100px;"></a></li>
	<li><a href="javascript:newUser()">회원가입</a></li>
</ol>
<hr>
<a href="control.jsp?action=main&mcnt=${mcnt+1}&selUser=${selUser}">더보기&gt;&gt;</a>

<hr>

<h2>전체목록</h2>
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>[${m.userID}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.mdate}]
	
	<a href="control.jsp?action=updatemsg&mid=${m.mid}&mcnt=${mcnt}&selUser=${selUser}">💚</a>
	
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

<!-- <a href="insertUser.jsp">회원가입</a> <br> -->

<mytag:login />

<hr>

<h4>신규 회원 목록</h4>
<ol>
	<c:forEach var="u" items="${newUsers}">
		<li><a href="control.jsp?action=main&mcnt=${mcnt}&selUser=${u.userID}">${u.name}</a>님  가입</li>
	</c:forEach>
</ol>
</div>

<div class="img">
<ul>
	<li><a href="https://www.youtube.com/watch?v=xlmPbjAcRXQ"><img alt="뽀로로이미지" src="image/pororo.png"></a></li>
	<li><a href="https://www.youtube.com/watch?v=pAkE0mK1_ds&list=PLXO7jFcjiAWC6p2c6pd6L98eBqMKJS4zV"><img alt="디즈니이미지" src="image/dog.jpg"></a></li>
	<li><a href="https://www.youtube.com/watch?v=BmDT1eq23l4"><img alt="버섯이미지" src="image/mushroom.ico"></a></li>
</ul>
</div>


</body>
</html>