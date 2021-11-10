package controller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.message2.Message2DAO;
import model.message2.Message2VO;

public class M_updateController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message2DAO mDAO=new Message2DAO();
		Message2VO mVO=new Message2VO();
		
		mVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		mVO.setTitle(request.getParameter("title"));
		mVO.setContent(request.getParameter("content"));
		mVO.setUserID(request.getParameter("userID"));
		
		System.out.println("mVO: "+mVO);
		
		ModelAndView mav=new ModelAndView();
		
		if(!mDAO.m_update(mVO)) {
			throw new IOException("글 수정에서 발생!");
		} else {
			mav.setViewName("list.do");
		}

		return mav;
	}
	
	
}
