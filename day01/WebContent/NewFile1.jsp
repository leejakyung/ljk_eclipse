<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	// 변수 선언
	int result = 0;
	
	// 내장 객체
	if (request.getMethod().equals("POST")) { // 무조건 대문자 작성
		String op = request.getParameter("op");

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		// 파라미터 값은 문자열로 주고 받음

		if (op.equals("+")) {
			result = num1 + num2;
		} else if (op.equals("-")) {
			result = num1 - num2;
		} else if (op.equals("*")) {
			result = num1 * num2;
		} else if (op.equals("/")) {
			result = num1 / num2;
		}

	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 실습1</title>
</head>
<body>

	<h2>계산기</h2>
	<hr>
	<form method="post" name="form1">
		<input type="text" id="num1" name="num1"> <select name="op">
			<option selected>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select> 
	<input type="text" id="num2" name="num2">
    <input type="submit" value="계산하기" name="btn1">
    <input type="reset" value="다시입력" name="btn2">

	</form>
	<hr>
	<h3>계산결과: <%= result %></h3>
</body>
</html>