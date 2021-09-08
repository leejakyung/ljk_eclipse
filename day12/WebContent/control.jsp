<%@page import="java.util.ArrayList, model.comment.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="commentDAO" class="model.comment.CommentDAO" />
<jsp:useBean id="commentVO" class="model.comment.CommentVO" scope="session" />
<jsp:setProperty property="*" name="commentVO"/>
<%

	String action =request.getParameter("action");

	if(action.equals("main")){
		ArrayList<CommentVO> datas =null;
		datas=commentDAO.getDBList();
		session.setAttribute("datas", datas);
		response.sendRedirect("main.jsp");
	} else if(action.equals("login")){
		System.out.println(commentVO);
		if(commentDAO.login(commentVO)!=null){
			CommentVO data=commentDAO.login(commentVO);
			session.setAttribute("mem", data);
			response.sendRedirect("control.jsp?action=reviewList");
		} else{
			out.println("<script>alert('로그인에 실패! 정보를 확인하세요!');history.go(-1)</script>");
		}
	} else if(action.equals("mylist")){ // 내 리뷰 보기
		ArrayList<CommentVO> datas= null;
		datas=commentDAO.getMyDBList(commentVO.getRid());
		session.setAttribute("datas", datas);
		pageContext.forward("reviewList.jsp");
	} else if(action.equals("insert")){ // 리뷰 등록
		if(commentDAO.insertDB(commentVO)){
			response.sendRedirect("control.jsp?action=reviewList");
		} else{
			throw new Exception("DB insert 오류 발생!");
		}
	} else if(action.equals("delete")){ // 리뷰 삭제
		if(commentDAO.deleteDB(commentVO)){
			response.sendRedirect("control.jsp?action.reviewList");
		} else{
			throw new Exception("DB dalete 오류 발생!");
		}
	} /* else if(action.equals("edit")){
		CommentVO data = commentDAO.getDBData(commentVO);
		session.setAttribute("data", data);
		pageContext.forward("reviewEdit.jsp"); */
	else{
		out.println("파라미터 확인!");
	}

%>