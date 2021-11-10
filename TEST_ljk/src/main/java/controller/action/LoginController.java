package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.client2.Client2DAO;
import model.client2.Client2VO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Client2DAO cDAO=new Client2DAO();
		Client2VO cVO=new Client2VO();
		
		cVO.setUserID(request.getParameter("userID"));
		cVO.setUserPW(request.getParameter("userPW"));
		
		cVO = cDAO.login(cVO); // 재사용
		
		ModelAndView mav=new ModelAndView();
		
		
		if(cVO!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", cVO);
			/*forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("list.do")*/;
			mav.setViewName("redirect:main.do"); // 기존의 VR의 설정을 무시하고 redirect
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out=response.getWriter();
	        out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
	        mav.setViewName("redirect:login.jsp");
	        // DS -> HM -> C -> VR
	        // VR이 경로를 완성 시켜줄 것이기 때문에
	        // .jsp/.do 를 쓸 필요없이  컨트롤러를 거치지 않고 가능 
		}
		return mav;
	}

	

}
