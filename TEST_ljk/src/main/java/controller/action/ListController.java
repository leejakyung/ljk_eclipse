package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.client2.Client2VO;
import model.message2.Message2DAO;
import model.message2.Message2VO;

public class ListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message2DAO mDAO=new Message2DAO();
		
		HttpSession session=request.getSession(); // 세션을 쓰려면 먼저 선언해주어야함
		
		String isMine = request.getParameter("isMine");
		ArrayList<Message2VO> datas=new ArrayList<Message2VO>();
		System.out.println("ismine :" + isMine);
		
		ModelAndView mav=new ModelAndView();
		
		if(isMine == null) {
			datas = mDAO.getDBList(null);
			System.out.println("mdatas null :" + datas);
		}
		else {
			datas = mDAO.getDBList((Client2VO)session.getAttribute("seUser"));
			System.out.println("mdatas true :" + datas);
		}
		
		mav.addObject("mdatas", datas); 
		mav.setViewName("list.do");
				
		return mav;
	}

	

}
