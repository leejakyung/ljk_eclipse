package controller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.client2.Client2DAO;
import model.client2.Client2VO;

public class C_deleteController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Client2DAO cDAO=new Client2DAO();
		Client2VO cVO= new Client2VO();
		
		cVO.setEmail(request.getParameter("email"));
		
		ModelAndView mav=new ModelAndView();
		
		if(!cDAO.delete(cVO)) { 
			throw new IOException("È¸¿ø Å»Åð¿¡¼­ ¹ß»ý!");
		}
		HttpSession session=request.getSession();
		session.invalidate();
		mav.setViewName("main.do");
		
		return mav;
	}

	

}
