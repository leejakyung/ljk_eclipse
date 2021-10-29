package controller.action;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.comments.CommentsService;
import model.comments.CommentsVO;
import model.shoes.ShoesDAO;
import model.shoes.ShoesService;
import model.shoes.ShoesVO;

@Controller
public class ShoesController {
	

	@Autowired
	private ShoesService shoesService;
	@Autowired
	private CommentsService commentsService;

	@RequestMapping("/sinsert.do") // 신발 게시물 등록
	public String s_insert(HttpServletRequest request,ShoesVO sVO,ShoesDAO sDAO,ModelAndView mav) throws IllegalStateException, IOException {
		
		String saveDir = request.getSession().getServletContext().getRealPath("images");// 해당 폴더에 이미지를 저장시킴
		System.out.println("saveDir" + saveDir);
		
		MultipartFile fileUpload=sVO.getFileUpload();
		System.out.println(fileUpload);
		if(!fileUpload.isEmpty()) {
			sVO.setFilename(fileUpload.getOriginalFilename());
			System.out.println(sVO.getFilename());
			fileUpload.transferTo(new File(saveDir+"/"+sVO.getFilename()));
		}
		
		sDAO.s_insert(sVO);
	
		return "redirect:category.do";
		
	}
	@RequestMapping("/supdate.do") // 수정
	public String s_update(HttpServletRequest request,ShoesVO sVO,ShoesDAO sDAO,ModelAndView mav) throws IllegalStateException, IOException {
		
		String saveDir = request.getSession().getServletContext().getRealPath("images");// 해당 폴더에 이미지를 저장시킴
		System.out.println("saveDir" + saveDir);
		
		MultipartFile fileUpload=sVO.getFileUpload();
		System.out.println(fileUpload);
		if(!fileUpload.isEmpty()) {
			sVO.setFilename(fileUpload.getOriginalFilename());
			System.out.println(sVO.getFilename());
			fileUpload.transferTo(new File(saveDir+"/"+sVO.getFilename()));
		}
		
		sDAO.s_update(sVO);
	
		return "redirect:category.do";
		
	}
	@RequestMapping("/sdelete.do") // 삭제
	public String s_delete(HttpServletRequest request,ShoesVO sVO,ShoesDAO sDAO,ModelAndView mav) throws IllegalStateException, IOException {
		
		String saveDir = request.getSession().getServletContext().getRealPath("images");// 해당 폴더에 이미지를 저장시킴
		System.out.println("saveDir" + saveDir);
		
		MultipartFile fileUpload=sVO.getFileUpload();
		System.out.println(fileUpload);
		if(!fileUpload.isEmpty()) {
			sVO.setFilename(fileUpload.getOriginalFilename());
			System.out.println(sVO.getFilename());
			fileUpload.transferTo(new File(saveDir+"/"+sVO.getFilename()));
		}
		
		sDAO.s_delete(sVO);
	
		return "redirect:category.do";
		
	}
	
	@RequestMapping("/category.do") // 카테고리 페이지
	public String category(ShoesVO sVO,Model model) throws IllegalStateException, IOException {
		
		List<ShoesVO> datas=shoesService.getShoesList(sVO);
		model.addAttribute("datas", datas);
		
		
		return "category.jsp";
	
	}
	
	@RequestMapping("/shoesList.do") // 신발 상세페이지
	public String shoesList(ShoesVO sVO,Model model,CommentsVO mVO) throws IllegalStateException, IOException {
		
		List<CommentsVO> datas=commentsService.getDBList(mVO);
		sVO=shoesService.getShoesData(sVO);
		model.addAttribute("data", sVO);
		model.addAttribute("mdatas", datas);
		
		return "shoesList.jsp";
	
	}
	
}
