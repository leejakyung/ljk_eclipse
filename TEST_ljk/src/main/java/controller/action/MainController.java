package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.client2.Client2VO;
import model.message2.Message2DAO;
import model.message2.Message2VO;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message2DAO mDAO=new Message2DAO();
		Client2VO cVO = null;
		
		ArrayList<Message2VO> datas=new ArrayList<Message2VO>();
	
		datas = mDAO.getDBList(cVO);
	
		
		//request.setAttribute("mdatas", datas);
				
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("mdatas", datas);
		mav.setViewName("Tmain");
		return mav;
	}

	

}
