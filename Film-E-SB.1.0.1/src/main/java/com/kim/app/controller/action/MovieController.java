package com.kim.app.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kim.app.model.movie.MovieService;
import com.kim.app.model.page.PageService;


@Controller
public class MovieController {

	@Autowired
	private MovieService movieServiceImpl;
	
	@Autowired
	private PageService pageServiceImpl;
	
	@RequestMapping("/Main.do")
	public String Main(@RequestParam(value="page",defaultValue="1")int page,com.kim.app.model.page.PageVO pVO,Model model) {
		
		
		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(12);		//	페이지 게시물 수
		pVO.setPerPageSet(5);	//	페이지 수
		
		pVO.setTable("movie");
		pVO = pageServiceImpl.paging(pVO);
		model.addAttribute("datas", movieServiceImpl.m_selectDB_all_m(pVO));
		model.addAttribute("paging", pVO);
		model.addAttribute("page", page);
		

		return "main";
		
	}
	
}
