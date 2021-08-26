<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품을 구매 예정 목록에 추가하는 페이지</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	String product=request.getParameter("product");
	// 세션에게 배열을 설정
	// -> "배열": 크기를 알아야함! 
	// => 배열리스트(컬렉션)

	// ArrayList<String> list=new ArrayList<String>();
	ArrayList<String> list=(ArrayList)session.getAttribute("list");
	if(list==null){ // 최초 주문일시에만 
		list=new ArrayList<String>();
		session.setAttribute("list", list);
	}
	list.add(product);
	
%>

<script type="text/javascript">
	alert("<%=product %>(이)가 추가되었습니다!");
	// 바로 이전에 값을 넣어두었기 때문에 parameter값을 받아올 수 있음!
	history.go(-1); // 뒤로가기
	
</script>

</body>
</html>