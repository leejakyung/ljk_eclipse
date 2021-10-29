package controller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.comments.CommentsDAO;
import model.comments.CommentsVO;

@Controller
public class CommentsController {
	@RequestMapping("/minsert.do")
	public String m_insert(HttpServletRequest request,CommentsVO mVO,CommentsDAO mDAO) {
		mDAO.m_insert(mVO);
		
		return "redirect:list.do";
	}
	@RequestMapping("/mupdate.do")
	public String m_update(HttpServletRequest request,CommentsVO mVO,CommentsDAO mDAO,ModelAndView mav) throws Exception {
		
		System.out.println("mVO: "+mVO);
		
		if(!mDAO.m_update(mVO)) {
			throw new IOException("�� �������� �߻�!");
		} else {
			return "redirect:list.do";
		}

	}
	@RequestMapping("/mdelete.do")
	public String m_dalete(HttpServletRequest request,CommentsVO mVO,CommentsDAO mDAO,ModelAndView mav) throws Exception {

		System.out.println("�Խñ� ����");
		
		if(!mDAO.m_delete(mVO)) { // delete�� ����������
			throw new IOException("�� �������� �߻�!");
		}
		return "redirect:list.do";
		
	}
	@RequestMapping("/mlist.do")
	public String handleRequest(HttpServletRequest request,CommentsVO mVO,CommentsDAO mDAO,ModelAndView mav,HttpSession session) throws Exception {
		//CommentsDAO mDAO=new CommentsDAO();
		
		//HttpSession session=request.getSession(); // ������ ������ ���� �������־����
		
		/*String isMine = request.getParameter("isMine");
		ArrayList<CommentsVO> datas=new ArrayList<CommentsVO>();
		System.out.println("ismine :" + isMine);*/
		
		
		/*if(isMine == null) {
			datas = mDAO.getDBList(null);
			System.out.println("mdatas null :" + datas);
		}
		else {
			datas = mDAO.getDBList((Client2VO)session.getAttribute("seUser"));
			System.out.println("mdatas true :" + datas);
		}
		*/
		/*mav.addObject("mdatas", datas); 
		mav.setViewName("list.do");*/
				
		return "mlist.do";
	}

}

