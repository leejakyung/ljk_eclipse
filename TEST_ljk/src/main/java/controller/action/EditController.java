package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.message2.Message2DAO;
import model.message2.Message2VO;

public class EditController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Message2DAO mDAO=new Message2DAO();
		Message2VO mVO=new Message2VO();
		mVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		
		mVO=mDAO.getDBData(mVO);
	
		ModelAndView mav=new ModelAndView();
	
		request.setAttribute("mdata", mVO);
		mav.setViewName("edit.do");
		
		return mav;
		
	}



}
