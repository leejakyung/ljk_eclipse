package controller.action;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.client2.Client2DAO;
import model.client2.Client2VO;
import model.client2.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(HttpServletRequest request,Client2VO cVO,Client2DAO cDAO, HttpServletRequest response) {
		cVO = clientService.login(cVO); // 재사용
		
		
		if(cVO!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", cVO);
			return "redirect:main.do";
		}
		else {
	        return "redirect:login.jsp";
		}
		
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		
		session.invalidate();

		return "redirect:index.jsp";
	}
	/*@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginPrint(@ModelAttribute("guest")Client2VO cVO,Client2DAO cDAO) {
		cVO.setEmail("test0301@naver.com");
		cVO.setUserPW("1234");
		return "login.jsp";
	
	}*/
	
	@RequestMapping("/signup.do")
	public String cinsert(HttpServletRequest request, Client2VO cVO,Client2DAO cDAO)throws Exception {
	
		if(!clientService.insert(cVO)) { 
			throw new IOException("회원가입에서 발생!");
		}
		
		
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/cupdate.do")
	public String cupdate(HttpServletRequest request, Client2VO cVO,Client2DAO cDAO)throws Exception {
	
		System.out.println("cVO :"+ cVO);
		
		
		if(!clientService.update(cVO)) { 
			throw new IOException("회원정보 수정에서 발생!");
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", cVO);
			session.invalidate();
		}
	
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/cdelete.do")
	public String cdelete(HttpServletRequest request, Client2VO cVO,Client2DAO cDAO)throws Exception  {
	
		cVO.setEmail(request.getParameter("email"));
		
	
		if(!clientService.delete(cVO)) { 
			throw new IOException("회원 탈퇴에서 발생!");
		}
		HttpSession session=request.getSession();
		session.invalidate();
	
		
		return "redirect:main.do";
	}
	
	@RequestMapping("/checkID.do")
	public String checkID(Client2VO cVO, Model model,HttpServletResponse response) throws IOException {
		PrintWriter out =response.getWriter();
		
		if (cVO.getUserID() == null || cVO.getUserID() == "") { // 입력값이 없는 경우
			out.println("null");
		} else {
			out.println(clientService.checkID(cVO.getUserID()));
		}
		return null;
		
	}
	@RequestMapping("/checkEmail.do")
	public String checkEmail(Client2VO cVO, Model model,HttpServletResponse response) throws IOException {
		PrintWriter out =response.getWriter();
		
		if (cVO.getEmail() == null || cVO.getEmail() == "") { // 입력값이 없는 경우
			out.println("null");
		} else {
			out.println(clientService.checkEmail(cVO.getEmail()));
		}
		return null;
		
	}


	

}
