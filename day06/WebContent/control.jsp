<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,model.letter.*"
	errorPage="error.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="letterDAO" class="model.letter.LetterDAO" />
<jsp:useBean id="letterVO" class="model.letter.LetterVO" />
<jsp:setProperty property="*" name="letterVO" />
<%
	
	String action = request.getParameter("action");

	if (action.equals("list")) { 
		ArrayList<LetterVO> datas = letterDAO.getDBList();
		request.setAttribute("datas", datas);
		pageContext.forward("list.jsp");
	} else if (action.equals("insert")) { 
		if (letterDAO.insertDB(letterVO)) {
			response.sendRedirect("control.jsp?action=list");
		} else {
			throw new Exception("DB 추가 오류 발생!"); 
		}
	} else if (action.equals("delete")) {
		if (letterDAO.deleteDB(letterVO)) { 
			response.sendRedirect("control.jsp?action=list");
		} else {
			throw new Exception("DB 삭제 오류 발생!");
		}
	} else if (action.equals("update")) {

		if (letterDAO.updateDB(letterVO)) { 
			response.sendRedirect("control.jsp?action=list");
		} else { 
			throw new Exception("DB 변경 오류 발생!");
		}
	} else if (action.equals("edit")) {
		if (request.getParameter("writer").equals("admin")) {
			LetterVO data = letterDAO.getDBData(letterVO);
			request.setAttribute("data", data);
			pageContext.forward("edit.jsp");

		} else {
			out.println("<script>alert('관리자가 아닙니다!');history.go(-1)</script>");
		}
	} else {
		out.println("<script>alert('파라미터 확인!');hstory.go(-1)</script>");
	}
%>
























<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨트롤러</title>
</head>
<body>

</body>
</html>