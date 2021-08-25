<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>html코드 안에서 java코드를 운용할 수 있는가? - 실습</title>
</head>
<body>

   <%
   for (int i = 1; i <= 10; i++) {
      if (i % 2 == 0) {
         out.println("<div style='color:red;'>"+i + "<br>");
      }else{
         out.println("<div style='color:blue;'>"+i + "<br>");
      }
   }
   %>
   
   <!-- out.println 내장객체를 안에 직접 넣어줌 -->

	



</body>
</html>