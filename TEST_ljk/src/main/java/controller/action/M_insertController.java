package controller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.message2.Message2DAO;
import model.message2.Message2VO;

public class M_insertController  implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message2DAO mDAO=new Message2DAO();
		Message2VO mVO=new Message2VO();
		mVO.setTitle(request.getParameter("title"));
		mVO.setContent(request.getParameter("content"));
		mVO.setUserID(request.getParameter("userID"));
		
		ModelAndView mav=new ModelAndView();
		
		if(!mDAO.m_insert(mVO)) {
			throw new IOException("�� ��Ͽ��� �߻�!");
		}
		mav.setViewName("list.do");
		
		return mav;
	}

	

}
