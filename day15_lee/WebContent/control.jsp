<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.message.*,model.user.*"%>
<jsp:useBean id="mDAO" class="model.message.MessageDAO" />
<jsp:useBean id="rDAO" class="model.message.ReplyDAO" />
<jsp:useBean id="uDAO" class="model.user.UserDAO" />
<jsp:useBean id="mVO" class="model.message.MessageVO" />
<jsp:setProperty property="*" name="mVO"/>
<jsp:useBean id="rVO" class="model.message.ReplyVO" />
<jsp:setProperty property="*" name="rVO"/>
<jsp:useBean id="uVO" class="model.user.UserVO" />
<jsp:setProperty property="*" name="uVO"/>
<%
	String action=request.getParameter("action");
	/* String url="control.jsp?action=main";	
	String mcntt=request.getParameter("mcnt");  // model의 cnt
	int mcnt=2;
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url= url+ "&mcnt="+mcnt;
	String selUser=request.getParameter("selUser");
	if(selUser!=null){
		url= url+ "&selUser="+selUser;
	} */
			
	if(action.equals("main")){
		ArrayList<MsgSet> datas=mDAO.selectAll();
		// ArrayList<UserVO> newUsers=uDAO.selectAll();
		
		request.setAttribute("datas", datas);
		// request.setAttribute("newUsers", newUsers);
		// request.setAttribute("selUser", selUser);
		// request.setAttribute("mcnt", mcnt);
		System.out.println("확인!");
		pageContext.forward("main.jsp");
	}
%>