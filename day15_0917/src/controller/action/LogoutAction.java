package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserVO;

public class LogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ActionForward forward = null;

		// 1. uVO�� ����� �ִ� ���ڵ��� get()
		// 2. �α��� ����/���� ���� �Ǵ�
		// 3. ���� - ���Ǽ��� / ���� - ��ũ��Ʈ ���
		UserDAO uDAO=new UserDAO();
		UserVO uVO= new UserVO();
		uVO.setUpw(request.getParameter("upw"));
		uVO.setUserID(request.getParameter("userID"));
		
		HttpSession session=request.getSession();
		session.invalidate(); // ���ǿ� ����Ǿ� �ִ� ������ ��� �����ִ� ����
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("main.do");
		
		
		return forward;
	}


}
