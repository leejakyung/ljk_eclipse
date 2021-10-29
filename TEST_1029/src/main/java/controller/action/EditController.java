package controller.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.comments.CommentsDAO;
import model.comments.CommentsVO;

@Controller
public class EditController {

	@RequestMapping("/edit.do")
	public String edit(HttpServletRequest request, CommentsDAO mDAO, CommentsVO mVO,ModelAndView mav) {
		
		/*CommentsDAO mDAO=new CommentsDAO();
		CommentsVO mVO=new CommentsVO();
		mVO.setCnum(Integer.parseInt(request.getParameter("cnum")));
		
		mVO=mDAO.getDBData(mVO);
	
		ModelAndView mav=new ModelAndView();
	
		request.setAttribute("cdata", mVO);
		mav.setViewName("edit.do");*/
		

		return "redirect:edit.do";
		
	}



}
