<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>이름:<%=request.getParameter("name")%></h1>
<h1>학년:<%=request.getParameter("grade")%></h1>
<h1>수강과목:<%=request.getParameter("subject")%></h1>

</body>
</html>