<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.common.*"%>
   <%
   	request.setCharacterEncoding("UTF-8");
   %>    
<jsp:useBean id="loginDAO" class="model.common.LoginDAO" />
<jsp:useBean id="loginVO" class="model.common.LoginVO" scope="session"/>
<jsp:setProperty property="*" name="loginVO" />
<%
String action=request.getParameter("action");
if (action.equals("logInOut")) {
	response.sendRedirect("logInOut.jsp");
} else if(action.equals("login")){
	if(loginDAO.login(loginVO)){
		//LoginVO id=new LoginVO();
		session.setAttribute("mem", loginVO); // id 값을 넣어줌!
		
		response.sendRedirect("control.jsp?action=logInOut");	
	}
	else{
		out.println("<script>alert('로그인에 실패하였습니다. 정보를 다시 입력하세요.');history.go(-1)</script>");
	}
}  else if (action.equals("logout")) {
	session.invalidate(); // 데이터 초기화
	response.sendRedirect("control.jsp?action=logInOut");
}

%>
