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

		// 1. uVO를 만들수 있는 인자들은 get()
		// 2. 로그인 성공/실패 여부 판단
		// 3. 성공 - 세션세팅 / 실패 - 스크립트 출력
		UserDAO uDAO=new UserDAO();
		UserVO uVO= new UserVO();
		uVO.setUpw(request.getParameter("upw"));
		uVO.setUserID(request.getParameter("userID"));
		
		HttpSession session=request.getSession();
		session.invalidate(); // 세션에 저장되어 있는 정보를 모두 지워주는 역할
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("main.do");
		
		
		return forward;
	}


}
