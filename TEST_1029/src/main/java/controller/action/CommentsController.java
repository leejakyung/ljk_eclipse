package controller.action;

import java.io.IOException;
import java.util.List;

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
	
	
	@RequestMapping("/minsert.do")
	public String m_insert(CommentsVO mVO,Model model) {
		System.out.println(mVO);
		commentsService.m_insert(mVO);
		model.addAttribute("spk", mVO.getSpk());
		
		return "redirect:shoesList.do";
	}
	@RequestMapping("/mupdate.do")
	public String m_update(CommentsVO mVO,Model model) throws Exception {
		
		System.out.println("mVO: "+mVO);
		
		if(!commentsService.m_update(mVO)) {
			throw new IOException("글 수정에서 발생!");
		} else {
			return "redirect:shoesList.do";
		}

	}
	@RequestMapping("/mdelete.do")
	public String m_dalete(CommentsVO mVO,Model model) throws Exception {

		System.out.println("코멘트 삭제");
		
		if(!commentsService.m_delete(mVO)) { // delete에 실패했을때
			throw new IOException("글 삭제에서 발생!");
		}
		return "redirect:shoesList.do";
		
	}


}

