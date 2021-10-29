package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.client2.Client2VO;
import model.comments.CommentsDAO;
import model.comments.CommentsVO;

@Controller
public class ListController{

	@RequestMapping("/list.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommentsDAO mDAO=new CommentsDAO();
		
		HttpSession session=request.getSession(); // 세션을 쓰려면 먼저 선언해주어야함
		
		String isMine = request.getParameter("isMine");
		ArrayList<CommentsVO> datas=new ArrayList<CommentsVO>();
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
