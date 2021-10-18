package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message.MessageDAO;
import model.message.MsgSet;
import model.user.UserDAO;
import model.user.UserVO;



public class MainAction implements Action {

	@Override
	// private 사용 x -> 자식은 부모의 범위보다 넓거나 같아야 하기 때문.	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();

		String mcntt=request.getParameter("mcnt");
		int mcnt=3;
		if(mcntt!=null){
			mcnt=Integer.parseInt(mcntt);
		}

		String selUser=request.getParameter("selUser");

		MessageDAO mDAO=new MessageDAO();
		UserDAO uDAO=new UserDAO();
		ArrayList<MsgSet> datas=mDAO.selectAll(selUser, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();

		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("selUser", selUser);
		request.setAttribute("mcnt", mcnt);

		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}
}
