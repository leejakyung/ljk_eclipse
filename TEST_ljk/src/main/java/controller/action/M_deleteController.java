package controller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.message2.Message2DAO;
import model.message2.Message2VO;

public class M_deleteController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message2DAO mDAO=new Message2DAO();
		Message2VO mVO=new Message2VO();
		mVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		System.out.println("�Խñ� ����");
		
		ModelAndView mav=new ModelAndView();
		
		if(!mDAO.m_delete(mVO)) { // delete�� ����������
			throw new IOException("�� �������� �߻�!");
		}
		mav.setViewName("list.do");
		
		/*forward.setRedirect(true);
		// true -> redirect ������� �����ڴ�
		// false -> redirect ������� ������ �ʰڴ� , forward�� �����ڴ�.
		forward.setPath("list.do");*/
		
		// read�� forward�� ������ CUD�� redirect 
		return mav;
	}

	

}
