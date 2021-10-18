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

public class DeleteMsgAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		
		MessageDAO mDAO=new MessageDAO();
		MessageVO mVO=new MessageVO();
		mVO.setMid(Integer.parseInt(request.getParameter("mid")));
		System.out.println("메세지삭제");
		if(!mDAO.delete(mVO)) { // delete에 실패했을때
			throw new IOException("deletemsg에서 발생!");
		}
		
		
		
		/*
		String mcntt=request.getParameter("mcnt");
		int mcnt=3;
		if(mcntt!=null){
			mcnt=Integer.parseInt(mcntt);
		}

		String selUser=request.getParameter("selUser");

		UserDAO uDAO=new UserDAO();
		ArrayList<MsgSet> datas=mDAO.selectAll(selUser, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();*/ 
		// mainAction 에서 불러주기 때문에 이곳에서 페이징 처리 할 필요 xxx
		// get방식으로 url을 받아 쓰기 때문에 main.do에 유지가 계속됨 

		/*request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("selUser", selUser);
		request.setAttribute("mcnt", mcnt);*/

		forward.setRedirect(false);
		// true -> redirect 방식으로 보내겠다
		// false -> redirect 방식으로 보내지 않겠다 
		forward.setPath("main.do");
		return forward;
	}
}
