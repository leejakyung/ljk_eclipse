package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message.MessageDAO;
import model.message.MsgSet;
import model.message.ReplyDAO;
import model.message.ReplyVO;
import model.user.UserDAO;
import model.user.UserVO;

public class NewrpAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();

		// 1. rVO를 만들 수 있도록 get()
		// 2. rDAO로 insert()
		ReplyDAO rDAO=new ReplyDAO();
		ReplyVO rVO=new ReplyVO();
		rVO.setMid(Integer.parseInt(request.getParameter("mid")));
		rVO.setRmsg(request.getParameter("rmsg"));
		rVO.setUserID(request.getParameter("userID"));
		if(!rDAO.insert(rVO)) {
			throw new IOException("newrp에서 발생!");
		}
		
		

		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}
}
