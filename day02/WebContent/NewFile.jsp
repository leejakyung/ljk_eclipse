<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%--    <%@ page %>  페이지 지시어   --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2><%= new Date() %></h2> <!--  위에서 import -->
<!--  서블릿은 결국 자바 파일이기 때문에 -->
<!-- JSP 표현식=> 서블릿파일로 변환되었을때, -->
<%-- NewFile_jsp.java안에서 표현식 부분은 out.println(new Date()); --%>

</body>
</html>