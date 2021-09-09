<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import ="java.util.*,model.bank.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="b1" class="model.bank.Bank1DAO" />
<jsp:useBean id="b2" class="model.bank.Bank2DAO" />

<%
	String action=request.getParameter("action");
	if(action.equals("view")){
		Bank1VO data1=b1.getBank1();
		Bank2VO data2=b2.getBank2(); 
		session.setAttribute("data1", data1);
		session.setAttribute("data2", data2);
		pageContext.forward("view.jsp");
	}
	else if(action.equals("trans")){
	String name = request.getParameter("name1"); // name1에 적은 값을 가져옴
	Bank1VO data1=b1.getBank1();
	Bank2VO data2=b2.getBank2(); 
	System.out.println(name);
	
	
	String str = "잔액부족!";
	int bal = Integer.parseInt(request.getParameter("bal"));
	System.out.println("확인1");
	if (name.equals("아무무")) {
		if(b1.trans(bal)){
			str = "계좌이체 성공!";
			System.out.println("확인2");
		}
	} else if (name.equals("티모")) {
		if(b2.trans(bal)){
			str = "계좌이체 성공!";
		}
	}


	/* if (b1.trans(Integer.parseInt(request.getParameter("bal")))) {
		// out.println("<script>alert('계좌이체 성공!');</script>");
		str = "계좌이체 성공!";
	}

	if (b2.trans(Integer.parseInt(request.getParameter("bal")))) {
		str = "계좌이체 성공!";
	} */
	/* else{
		out.println("<script>alert('계좌이체 실패...');</script>");
	} */

	System.out.println(data1);
	System.out.println(data2);

	session.setAttribute("b1", data1);
	session.setAttribute("b2", data2);
	session.setAttribute("str", str);
	response.sendRedirect("control.jsp?action=view");
	}
%>