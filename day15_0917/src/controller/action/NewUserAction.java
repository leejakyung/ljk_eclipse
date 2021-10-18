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
			throw new IOException("newuser에서 발생!");
		}
		
		// sendRedirect == 다음 페이지에 정보를 넘길때 url과 post 정보를 초기화하고 보내는 것, 정보를 보내주고 없애는것  ex)delete
		// forward == 정보를 유지시켜서 전달해주는 방식 , 정보를 보내준 것을 한번 더 유지시켜줌

		forward.setRedirect(false);
		forward.setPath("main.do"); 
		return forward;
	}
}
