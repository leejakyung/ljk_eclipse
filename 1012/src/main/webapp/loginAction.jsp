<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member2.*, java.util.*"%>
    
<%
// 이전페이지에서 보낸 아이디 값과 비밀번호값을 getP 

// vo에 해당 값들을 set

// dao로 getMember() 수행

String id=request.getParameter("id");
String password=request.getParameter("password");

Member2VO vo = new Member2VO();
vo.setId(id);
vo.setPassword(password);

SpringMember2DAO dao=new SpringMember2DAO();
List<Member2VO> data=dao.getMem(vo);
if(data!=null){
	// 성공
	response.sendRedirect("main.jsp");
}
else{
	// 실패
	response.sendRedirect("index.jsp");
}

%>