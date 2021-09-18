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

public class NewmsgAction implements  Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		
		
		MessageDAO mDAO=new MessageDAO();
		MessageVO mVO=new MessageVO();
		mVO.setMsg(request.getParameter("msg"));
		mVO.setUserID(request.getParameter("userID"));
		if(!mDAO.insert(mVO)) {
			throw new IOException("newmsg에서 발생!");
		}
		
		
		String mcntt=request.getParameter("mcnt");
		int mcnt=3;
		if(mcntt!=null){
			mcnt=Integer.parseInt(mcntt);
		}

		String selUser=request.getParameter("selUser");

		UserDAO uDAO=new UserDAO();
		ArrayList<MsgSet> datas=mDAO.selectAll(selUser, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();

		/*request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("selUser", selUser);
		request.setAttribute("mcnt", mcnt);*/

		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}
}
