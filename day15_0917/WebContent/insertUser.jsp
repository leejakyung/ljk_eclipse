<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지</title>
<style type="text/css">
#signup{
	border-color: pink;
}

</style>
</head>
<body>

<form action="control.jsp" method="post">
	<input type="hidden" name="action" value="newUser">
	<table border="1" id="signup">
		<tr>
			<td>ID</td>
			<td><input type="text" placeholder="아이디를 입력하세요." name="userID"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" placeholder="비밀번호를 입력하세요." name="upw"></td>
		</tr>
		<tr>
			<td>NAME</td>
			<td><input type="text" placeholder="이름을 입력하세요." name="name"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>

</body>
</html>