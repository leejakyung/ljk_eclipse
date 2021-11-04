package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.client2.Client2VO;
import model.mine.MineService;
import model.mine.MineVO;
import model.shoes.ShoesVO;

@Controller
public class MineController {

	@Autowired
	private MineService mineService;
	
	@RequestMapping("/mineIns.do")
	public String mineIns(MineVO eVO,Model model) {
	
		System.out.println(eVO);
		mineService.mIns(eVO);
		model.addAttribute("spk", eVO.getSpk());
		
		return "redirect:shoesList.do";
	}
	
	@RequestMapping("/mineDel.do")
	public String mineDel(MineVO eVO,Model model) throws Exception {

	
		model.addAttribute("spk", eVO.getSpk());
		
		if(!mineService.mDel(eVO)) { // delete에 실패했을때
			throw new IOException("찜 취소에서 발생!");
		}
		return "redirect:shoesList.do";
		
	}
	
	@RequestMapping("/mine.do")
	public String mineList(HttpSession session,MineVO eVO,Model model) {
	
		Client2VO vo = (Client2VO)session.getAttribute("seUser");
		if(vo!=null) {
			eVO.setEmail(vo.getEmail());
		}
		System.out.println("mine eVO :" + eVO);
		
		List<ShoesVO> datas=mineService.getShoesList(eVO); //순서 중요!!
		
		System.out.println("mine datas :" + datas);
		
		model.addAttribute("datas", datas);
		
		return "mine.jsp";
	}

}
