<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %> 
<!DOCTYPE html>


<%
	// 변수 선언
	int result = 0;

	if (request.getMethod().equals("POST")) { // 무조건 대문자 작성

		String coffeeName = request.getParameter("coffeeName");
		int coffeeNum = Integer.parseInt(request.getParameter("coffeeNum"));
		// 파라미터 값은 문자열로 주고 받음

		if (coffeeName.equals("아메리카노")) {
			result = 2000 * coffeeNum;
		} else if (coffeeName.equals("카페라떼")) {
			result = 3000 * coffeeNum;
		} else if (coffeeName.equals("자몽허니블랙티")) {
			result = 5000 * coffeeNum;
		} else if (coffeeName.equals("자바프라푸치노")) {
			result = 6000 * coffeeNum;
		}

	}
%>

<html>
<head>
<meta charset="UTF-8">
<title>카페 키오스크 - 1번 방식 실습</title>
</head>
<body>

	<h2>HG벅스</h2>
	<table border="1">
		<tr>
			<td>아메리카노</td>
			<td>2000원</td>
		</tr>
		<tr>
			<td>카페라떼</td>
			<td>3000원</td>
		</tr>
		<tr>
			<td>자몽허니블랙티</td>
			<td>5000원</td>
		</tr>
		<tr>
			<td>자바칩프라푸치노</td>
			<td>6000원</td>
		</tr>
	</table>
	<hr>
	<form method="post" name="coffeeForm">
		<input type="text" id="coffName" name="coffeeName" placeholder="메뉴를 입력하세요"> 
		<input type="text" id="coffeeNum" name="coffeeNum" placeholder="수량을 입력하세요">
    	<input type="submit" value="계산하기" name="btn1">
    	<input type="reset" value="다시입력" name="btn2">

	</form>
	<hr>
	<h3>계산결과: <%= result %></h3>

</body>
</html>