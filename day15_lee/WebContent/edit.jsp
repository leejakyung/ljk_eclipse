<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 삭제</title>
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

<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>[${m.userID}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.mdate}]</h3>
	<ol><c:forEach  var="r" items="${v.rlist}">
		<li>${r.userID} >> ${r.rmsg} [${r.rdate}]</li>
	</c:forEach></ol>
</c:forEach>

<input type="button" value="댓글 삭제" onclick="del()">
<input type="button" value="메인으로 돌아가기" onclick="location.href='control.jsp?action=main'">

</body>
</html>