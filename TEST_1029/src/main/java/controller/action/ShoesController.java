package controller.action;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.client2.Client2VO;
import model.comments.CommentsService;
import model.comments.CommentsVO;
import model.mine.MineService;
import model.mine.MineVO;
import model.page.PageService;
import model.page.PageVO;
import model.shoes.ShoesService;
import model.shoes.ShoesVO;
import model.style.StyleService;
import model.style.StyleVO;

@Controller
public class ShoesController {


	@Autowired
	private ShoesService shoesService;
	@Autowired
	private CommentsService commentsService;
	@Autowired
	private StyleService styleService;
	@Autowired
	private MineService mineService;
	@Autowired
	private PageService pageService;

	@RequestMapping("/sinsert.do") // 신발 게시물 등록
	public String s_insert(HttpServletRequest request,ShoesVO sVO,Model model) throws IllegalStateException, IOException {

		String saveDir = request.getSession().getServletContext().getRealPath("images");// 해당 폴더에 이미지를 저장시킴
		System.out.println("saveDir" + saveDir);

		MultipartFile fileUpload=sVO.getFileUpload();
		System.out.println(fileUpload);
		if(!fileUpload.isEmpty()) {
			sVO.setFilename(fileUpload.getOriginalFilename());
			System.out.println(sVO.getFilename());
			fileUpload.transferTo(new File(saveDir+"/"+sVO.getFilename()));
		}

		shoesService.s_insert(sVO);

		return "redirect:adminList.do";

	}
	@RequestMapping("/supdate.do") // 수정
	public String s_update(HttpServletRequest request,ShoesVO sVO,Model model) throws IllegalStateException, IOException {

		String saveDir = request.getSession().getServletContext().getRealPath("images");		
		MultipartFile fileUpload=sVO.getFileUpload();

		sVO.setFilename(sVO.getFilename().replace("images/", ""));
		System.out.println("파일수정확인"+sVO); 
		if(!sVO.getFileUpload().isEmpty()) {												//파일이 null이 아닐시 이전에 로컬에 있던 이미지 삭제
			File preFile = new File(saveDir+"/"+sVO.getFilename());
			preFile.delete();
			System.out.println("이전 파일" + sVO.getFilename());

			sVO.setFilename(/*UUID.randomUUID().toString()+*/fileUpload.getOriginalFilename());
			fileUpload.transferTo(new File(saveDir+"/"+sVO.getFilename()));
			System.out.println("이후 파일" + sVO.getFilename());

		}

		shoesService.s_update(sVO);
		return "redirect:adminList.do";

	}
	@RequestMapping("/sdelete.do") // 삭제
	public String s_delete(HttpServletRequest request,ShoesVO sVO,Model model) throws IllegalStateException, IOException {

		String saveDir = request.getSession().getServletContext().getRealPath("images");
		File file = new File(saveDir+"/"+sVO.getFilename());

		System.out.println(sVO);
		if(shoesService.s_delete(sVO)) { //파일 삭제
			file.delete();
		} 

		return "redirect:adminList.do";

	}

	@RequestMapping("/category.do") // 카테고리 페이지
	public String category(ShoesVO sVO,PageVO pVO,Model model,@RequestParam(value="page",defaultValue="1")int page) throws IllegalStateException, IOException {

		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(9);		//	페이지 게시물 수
		pVO.setPerPageSet(3);	//	페이지 수
		
		model.addAttribute("keyword", sVO.getKeyword());
		model.addAttribute("brandname", sVO.getBrandname());
		
		pVO = pageService.paging(pVO, sVO,"category");
		
		List<ShoesVO> datas=shoesService.getShoesList(sVO,pVO);
		model.addAttribute("datas", datas);
		model.addAttribute("paging", pVO);
		model.addAttribute("page", page);

		System.out.println(sVO);
		System.out.println(pVO);
		System.out.println("카테고리 페이징 성공");

		return "category.jsp";

	}

	@RequestMapping("/shoesList.do") // 신발 상세페이지
	public String shoesList(HttpSession session,PageVO pVO,ShoesVO sVO,Model model,CommentsVO mVO,StyleVO stVO,MineVO eVO,@RequestParam(value="scnt",defaultValue="3")int scnt,@RequestParam(value="page",defaultValue="1")int page) throws IllegalStateException, IOException {

		Client2VO vo = (Client2VO)session.getAttribute("seUser");
		if(vo!=null) {
			eVO.setEmail(vo.getEmail());
		}
		
		System.out.println("evo : " + eVO);
		

		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(5);		//	페이지 게시물 수
		pVO.setPerPageSet(3);	//	페이지 수
		
		pVO = pageService.paging(pVO, sVO,"shoesList");
		
		
		List<StyleVO> stdatas = styleService.getStyleList(stVO, scnt);
		List<CommentsVO> datas=commentsService.getDBList(mVO, pVO);
		eVO=mineService.mine(eVO);
		System.out.println("evo fix : " + eVO);
		sVO=shoesService.getShoesData(sVO);
		model.addAttribute("data", sVO);
		model.addAttribute("mdatas", datas);
		model.addAttribute("stdatas", stdatas);
		model.addAttribute("edata", eVO);
		model.addAttribute("scnt", scnt);
		
		model.addAttribute("datas", datas);
		model.addAttribute("paging", pVO);
		model.addAttribute("page", page);

		return "shoesList.jsp";

	}

	@RequestMapping("/adminList.do") // 관리자 카테고리페이지
	public String adminList(ShoesVO sVO,PageVO pVO,Model model,@RequestParam(value="page",defaultValue="1")int page) throws IllegalStateException, IOException {

		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(9);		//	페이지 게시물 수
		pVO.setPerPageSet(3);	//	페이지 수
		model.addAttribute("keyword", sVO.getKeyword());
		model.addAttribute("brandname", sVO.getBrandname());
		
		pVO = pageService.paging(pVO, sVO,"category");
		List<ShoesVO> datas=shoesService.getShoesList(sVO,pVO);
		model.addAttribute("datas", datas);
		model.addAttribute("paging", pVO);
		model.addAttribute("page", page);


		return "adminList.jsp";

	}

	@RequestMapping("/admin.do") // 관리자 상세페이지
	public String admin(ShoesVO sVO,Model model) throws IllegalStateException, IOException {
		System.out.println("확인"+sVO);
		sVO=shoesService.getShoesData(sVO);
		model.addAttribute("data", sVO);

		return "admin.jsp";

	}

}
