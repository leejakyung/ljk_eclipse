package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.comments.CommentsService;
import model.comments.CommentsVO;

@Controller
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;
	
	
	@RequestMapping("/minsert.do") // ��� ���ε�
	public String m_insert(CommentsVO mVO,Model model) {
		System.out.println(mVO);
		commentsService.m_insert(mVO);
		model.addAttribute("spk", mVO.getSpk());
		
		return "redirect:shoesList.do";
	}
	
	@RequestMapping("/updateTodo.do")
	public void updateTodo(CommentsVO mVO, HttpServletResponse response) {
		System.out.println("��� ���� Ȯ��");
		commentsService.m_update(mVO);
		//String data = mVO.getContent();
		try {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out =response.getWriter();
			System.out.println(mVO.getContent());
			//out.println("true"); 
			out.println("[{\"name\":\"" + mVO.getContent()+"\"}]"); 
			//out.println(mVO.getContent()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	@RequestMapping("/deleteTodo.do")
	public void deleteTodo(CommentsVO mVO, HttpServletResponse response) {
		commentsService.m_delete(mVO);
		try {
			PrintWriter out =response.getWriter();
			out.print(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	
/*	@RequestMapping("/mupdate.do")
	public String m_update(CommentsVO mVO,Model model) throws Exception {
		
		System.out.println("mVO: "+mVO);
		
		if(!commentsService.m_update(mVO)) {
			throw new IOException("�� �������� �߻�!");
		} else {
			return "redirect:shoesList.do";
		}

	}*/
	/*@RequestMapping("/mdelete.do")
	public String m_dalete(CommentsVO mVO,Model model) throws Exception {

		System.out.println("�ڸ�Ʈ ����");
		model.addAttribute("spk", mVO.getSpk());
		
		if(!commentsService.m_delete(mVO)) { // delete�� ����������
			throw new IOException("�� �������� �߻�!");
		}
		return "redirect:shoesList.do";
		
	}*/


}

