<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,model.message.*,model.user.*"%>
<jsp:useBean id="mDAO" class="model.message.MessageDAO" />
<jsp:useBean id="rDAO" class="model.message.ReplyDAO" />
<jsp:useBean id="uDAO" class="model.user.UserDAO" />
<jsp:useBean id="mVO" class="model.message.MessageVO" />
<jsp:setProperty property="*" name="mVO" />
<jsp:useBean id="rVO" class="model.message.ReplyVO" />
<jsp:setProperty property="*" name="rVO" />
<jsp:useBean id="uVO" class="model.user.UserVO" />
<jsp:setProperty property="*" name="uVO" />
<%
	String action=request.getParameter("action");
 	System.out.println(action);
	String url="control.jsp?action=main";	
	String mcntt=request.getParameter("mcnt");
	System.out.println(mcntt);
	int mcnt=0;
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url= url+ "&mcnt="+mcnt;
	String selUser=request.getParameter("selUser");
	if(selUser!=null){
		url= url+ "&selUser="+selUser;
	}
	System.out.println(url);	
	if(action.equals("main")){
		
		ArrayList<MsgSet> datas=mDAO.selectAll(selUser, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("selUser", selUser);
		request.setAttribute("mcnt", mcnt);
		System.out.println(mcnt);
		
		pageContext.forward("main.jsp");
	} else if(action.equals("mainAll")){
		System.out.println("리스트확인");
		ArrayList<MsgSet> datas=mDAO.selectAll(null, mcnt);
		// ArrayList<UserVO> newUsers=uDAO.selectAll();
		request.setAttribute("datas", datas);
		// request.setAttribute("newUsers", newUsers);
		// request.setAttribute("selUser", selUser);
		request.setAttribute("mcnt", mcnt);
		
		pageContext.forward("main.jsp");
	}
	else if(action.equals("login")){
		if(uDAO.login(uVO)){
	session.setAttribute("seUser", uVO.getUserID());
	response.sendRedirect(url);
		}
		else{
	out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
	}
	else if(action.equals("logout")){
		session.invalidate();
		///session.removeAttribute("selUser");
		response.sendRedirect("control.jsp?action=main");
	} 
	else if (action.equals("signup")) {
		System.out.println(uVO);

		if (uDAO.signup(uVO)) {
			out.println("<script>alert('회원가입 완료!!')</script>");
			pageContext.forward("control.jsp?action=main");
		} else {
			out.println("<script>alert('회원가입에 실패하셨습니다. 정보를 다시 확인해주세요.');history.go(-1);</script>");
		}
	}
	else if(action.equals("newmsg")){
		if(mDAO.insert(mVO)){
		pageContext.forward("control.jsp?action=main");
		}
	}
	else if(action.equals("newrmsg")){

		if(rDAO.insert(rVO)){
		pageContext.forward("control.jsp?action=main");
		}
	}
	// 페이징 처리 -> 아래 delete 두가지 방법 둘다 사용 가능  
	else if(action.equals("delete")){ // 댓글 삭제
		System.out.println("삭제 확인");
		/* System.out.println(request.getParameter("mcnt")); */
		/* request.setAttribute("mcnt",request.getParameter("mcnt")); */
		
		
		if(mDAO.delete(mVO)){
			response.sendRedirect(url);
		} else{
			throw new Exception("DB delete 오류 발생!");
		}
	}
	else if(action.equals("Rdelete")){ // 댓글 삭제
		System.out.println("삭제 확인");
		request.setAttribute("mcnt",request.getParameter("mcnt"));
		if(rDAO.delete(rVO)){
			pageContext.forward("control.jsp?action=main");
		} else{
			throw new Exception("DB delete 오류 발생!");
		}
	}
	
%>