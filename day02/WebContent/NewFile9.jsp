<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워딩 vs 리다이렉팅</title>
</head>
<body>


<form action="forward2.jsp" method="post">
	<input type="text" name="name" placeholder="이름">
	<input type="text" name="grade" placeholder="학년">
	<input type="text" name="subject" placeholder="수강과목">
	<input type="submit" value="제출하기">
</form>


<hr>

<form action="response_sendRedirect2.jsp" method="post">
   	<input type="text" name="name" placeholder="이름">
	<input type="text" name="grade" placeholder="학년">
	<input type="text" name="subject" placeholder="수강과목">
   	<input type="submit" value="제출하기">
</form>

</body>
</html>