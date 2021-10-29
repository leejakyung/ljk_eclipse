package controller.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@ModelAttribute("sm")
	public Map<String,String> searchMap(){ 
		Map<String,String> sm=new HashMap<String, String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}
	
	@RequestMapping("/main.do")
	public String mainpage(@RequestParam(value="condition", defaultValue="title", required=false)String condition,@RequestParam(value="keyword",defaultValue="",required=false)String keyword,Model model) {
		System.out.println(condition+": "+keyword);
		/*Message2DAO mDAO=new Message2DAO();
		Client2VO cVO = null;
		
		ArrayList<Message2VO> datas=new ArrayList<Message2VO>();
	
		datas = mDAO.getDBList(cVO);
	*/
		
		//request.setAttribute("mdatas", datas);
				
		
		//ModelAndView mav=new ModelAndView();
		//model.addObject("mdatas", datas);
		//model.setViewName("Tmain");
		return "main.jsp";
	}

	

}
