package controller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.client2.Client2DAO;
import model.client2.Client2VO;

public class C_updateController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Client2DAO cDAO=new Client2DAO();
		Client2VO cVO= new Client2VO();
		
		cVO.setUserID(request.getParameter("userID"));
		cVO.setUserPW(request.getParameter("userPW"));
		cVO.setEmail(request.getParameter("email"));
		
		System.out.println("cVO :"+ cVO);
		
		ModelAndView mav=new ModelAndView();
		
		if(!cDAO.update(cVO)) { 
			throw new IOException("회원정보 수정에서 발생!");
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", cVO);
		}
		mav.setViewName("list.do");
		
		return mav;
	}



}
