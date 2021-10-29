package controller.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.shoes.ShoesDAO;
import model.shoes.ShoesVO;

@Controller
public class ShoesController {

	@RequestMapping("/sinsert.do")
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
	
		return "redirect:admin.jsp";
		
	}
	
}
