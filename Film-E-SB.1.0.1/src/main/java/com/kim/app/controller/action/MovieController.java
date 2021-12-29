package com.kim.app.controller.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kim.app.model.movie.MovieMultiVO;
import com.kim.app.model.movie.MovieService;
import com.kim.app.model.movie.MovieVO;
import com.kim.app.model.page.PageService;
import com.kim.app.model.page.PageVO;


@Controller
public class MovieController {

	@Autowired
	private MovieService movieServiceImpl;
	
	@Autowired
	private PageService pageServiceImpl;
	
	@RequestMapping("/Main.do")
	public String Main(@RequestParam(value="page",defaultValue="1")int page,PageVO pVO,Model model) {
		
		
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
	
	@RequestMapping("/Adminlist.do")
	public String Adminlist(@RequestParam(value="page",defaultValue="1")int page,PageVO pVO,Model model) {
		
		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(12);		//	페이지 게시물 수
		pVO.setPerPageSet(5);	//	페이지 수
		
		pVO.setTable("movie");
		pVO = pageServiceImpl.paging(pVO);
		model.addAttribute("datas", movieServiceImpl.m_selectDB_all(pVO));
		model.addAttribute("paging", pVO);
		model.addAttribute("page", page);
		model.addAttribute("search", pVO.getSearch());
		
		return "adminlist";
		
	}
	
	@RequestMapping("/Categories.do")
	public String Categories(@RequestParam(value="page",defaultValue="1")int page,PageVO pVO,Model model) {
		
		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(8);		//	페이지 게시물 수
		pVO.setPerPageSet(5);	//	페이지 수
		
		pVO.setTable("movie");
		pVO = pageServiceImpl.paging(pVO);
		model.addAttribute("datas", movieServiceImpl.m_selectDB_all(pVO));
		model.addAttribute("paging", pVO);
		model.addAttribute("page", page);
		model.addAttribute("search", pVO.getSearch());
		model.addAttribute("mtype", pVO.getMtype());
		
		return "categories";
		
	}
	@RequestMapping("Admin.do")
	public String admin(MovieVO vo,Model model) {
		model.addAttribute("datas", movieServiceImpl.m_selectDB_one(vo));		
		return "admin";
	}
	
	
	
	@RequestMapping("/Minsert.do")
	public String minsert(HttpServletRequest request, HttpServletResponse response, MovieMultiVO vo) throws IOException {
		
		PrintWriter out = response.getWriter();
		String saveDir = request.getSession().getServletContext().getRealPath("img");
		MultipartFile fileupload = vo.getFilename();
		
		if(!fileupload.isEmpty()) {
			vo.setFiledb(UUID.randomUUID().toString().substring(7) + fileupload.getOriginalFilename());
			fileupload.transferTo(new File(saveDir + "/" + vo.getFiledb()));
		}
		
		if(movieServiceImpl.m_insertDB(vo)) {
			return "redirect:Adminlist.do";
		}else {
			File file = new File(saveDir + "/" + vo.getFiledb());
			if(file.exists()) { // 파일이 존재하면 삭제
				file.delete();
			}
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('게시물 등록 실패');history.go(-1)</script>");// 게시물 등록 실패 시 alert
			return null;
		}
	}
}
