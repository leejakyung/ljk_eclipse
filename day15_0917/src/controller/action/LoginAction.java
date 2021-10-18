package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.message.MessageDAO;
import model.message.MsgSet;
import model.user.UserDAO;
import model.user.UserVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) // ���⿡ ���� ���� ���� 
			throws ServletException, IOException {
		
		ActionForward forward = null;

		// 1. uVO�� ����� �ִ� ���ڵ��� get()
		// 2. �α��� ����/���� ���� �Ǵ�
		// 3. ���� - ���Ǽ��� / ���� - ��ũ��Ʈ ���
		UserDAO uDAO=new UserDAO();
		UserVO uVO= new UserVO();
		uVO.setUpw(request.getParameter("upw"));
		uVO.setUserID(request.getParameter("userID"));
		
		if(uDAO.login(uVO)) {
			HttpSession session=request.getSession(); // �׷� �� ���� �ۼ����� �ʾƵ� ok
			session.setAttribute("seUser", uVO.getUserID());
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out=response.getWriter();
	        out.println("<script>alert('�α��� ����!');history.go(-1);</script>");
		}
		
		
		return forward;
	}

}
