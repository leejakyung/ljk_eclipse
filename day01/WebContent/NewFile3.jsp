<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>  <%-- 한글 파일 --%>  
<jsp:useBean id="coffee" class="test.CoffeeBean" />
<jsp:setProperty property="*" name="coffee"/>
<!DOCTYPE html>

<% coffee.coffeeOrder(); %>

<html>
<head>
<meta charset="UTF-8">
<title>카페 키오스크 - 2번 방식 실습</title>
</head>
<body>

<h2>커피 키오스크</h2>
<hr>
<form method="post" id="coffeeForm" name="coffeeForm">
   <select name="coffeeName" id="coffeeName">
      <option selected>아메리카노</option>
      <option>카페라떼</option>
      <option>바닐라라떼</option>
      <option>돌체라떼</option>
   </select>
   <input type="text" id="num" name="num" placeholder="개 수 입력">
   <input type="submit" value="계산하기" name="btn1">
   <input type="reset" value="다시입력" name="btn2">
  <hr>
  <h3>지불할 금액: <jsp:getProperty property="result" name="coffee"/></h3>
  
   
</form>

</body>
</html>