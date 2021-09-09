<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.bank.*, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트랜잭션 - 실습</title>
<style type="text/css">
	.font{
		color: red;
	}
</style>
</head>
<body>

<table border="1">
	<tr>
		<td>${b1.name}</td>
		<td>${b1.balance}</td>
	</tr>
	<tr>
		<td>${b2.name}</td>
		<td>${b2.balance}</td>
	</tr>
</table>
<p class="font">${str}</p>


<hr>

<form  method="post" action="control.jsp">
	<input type="hidden" name="action" value="trans">
	<input type="text" name="name1" placeholder="이름 입력">
	<input type="text" name="bal" placeholder="금액 입력">
	<input type="submit" value="계좌이체">
</form>

</body>
</html>