package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message.MessageDAO;
import model.message.MessageVO;
import model.message.MsgSet;
import model.user.UserDAO;
import model.user.UserVO;

public class NewUserAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		
		
		UserDAO uDAO=new UserDAO();
		UserVO uVO=new UserVO();
		uVO.setUserID(request.getParameter("userID"));
		uVO.setUpw(request.getParameter("upw"));
		uVO.setName(request.getParameter("name"));
		if(!uDAO.insert(uVO)) { 
			throw new IOException("newuser���� �߻�!");
		}
		
		// sendRedirect == ���� �������� ������ �ѱ涧 url�� post ������ �ʱ�ȭ�ϰ� ������ ��, ������ �����ְ� ���ִ°�  ex)delete
		// forward == ������ �������Ѽ� �������ִ� ��� , ������ ������ ���� �ѹ� �� ����������

		forward.setRedirect(false);
		forward.setPath("main.do"); 
		return forward;
	}
}
