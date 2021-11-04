package controller.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.style.StyleService;
import model.style.StyleVO;

@Controller
public class StyleController {

	@Autowired
	private StyleService styleService;
	
	@RequestMapping(value = "/stinsert.do", method=RequestMethod.POST) // �� �Ź��ڶ��ϱ� �Խù� ���
	public String st_insert(HttpServletRequest request,StyleVO stVO,Model model) throws IllegalStateException, IOException {
		
		String saveDir = request.getSession().getServletContext().getRealPath("images");// �ش� ������ �̹����� �����Ŵ
		System.out.println("saveDir" + saveDir);
		
		MultipartFile fileUpload=stVO.getFileUpload();
		System.out.println(fileUpload);
		System.out.println("stinsert VO : " + stVO);
		if(!fileUpload.isEmpty()) {
			stVO.setFilename(fileUpload.getOriginalFilename());
			System.out.println(stVO.getFilename());
			fileUpload.transferTo(new File(saveDir+"/"+stVO.getFilename()));
		}
		
		model.addAttribute("spk", stVO.getSpk());
		System.out.println(stVO);
		styleService.st_insert(stVO);
	
		return "redirect:shoesList.do";
		
	}
	
	@RequestMapping("/stdelete.do") // �� �Ź��ڶ��ϱ� �Խù� ����
	public String st_delete(HttpServletRequest request,StyleVO stVO,Model model) throws IllegalStateException, IOException {
		
		
		String saveDir = request.getSession().getServletContext().getRealPath("images");
		File file = new File(saveDir+"/"+stVO.getFilename());

		System.out.println(stVO);
		if(styleService.st_delete(stVO)) { //���� ����
			file.delete();
		} 
		model.addAttribute("spk", stVO.getSpk());
		
	
		return "redirect:shoesList.do";
		
	}
	
}
