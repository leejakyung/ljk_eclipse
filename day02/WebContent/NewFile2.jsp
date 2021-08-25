<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 지시어</title>
<!--  협업 외부에 있는 것을 끌고 들어와서 하나의 servlet으로 만듦 -->
<!--  자주 바뀌는 것들에는 적합하지 않음 ex)광고, 뉴스 -->
<style type="text/css">
#box1{
	border: 1px solid red;
}
#box2{
	border: 1px solid blue;
}
</style>
</head>
<body>

<%@ include file="menu.jsp" %>
<hr>
<div id="box1"><%@ include file="news.jsp" %></div>
<div id="box2"><%@ include file="shopping.jsp" %></div>

</body>
</html>