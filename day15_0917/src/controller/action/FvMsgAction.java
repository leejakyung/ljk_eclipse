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

public class FvMsgAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		
		MessageDAO mDAO=new MessageDAO(); // ==useBean
		MessageVO mVO=new MessageVO(); // ==useBean
		mVO.setMid(Integer.parseInt(request.getParameter("mid"))); // setProperty
		
		mDAO.update(mVO); // void 이기 때문에 
		
		
		
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
		request.setAttribute("mcnt", mcnt);
*/
		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}

}
