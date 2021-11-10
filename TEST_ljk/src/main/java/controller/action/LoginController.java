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
		
		cVO = cDAO.login(cVO); // ����
		
		ModelAndView mav=new ModelAndView();
		
		
		if(cVO!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", cVO);
			/*forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("list.do")*/;
			mav.setViewName("redirect:main.do"); // ������ VR�� ������ �����ϰ� redirect
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out=response.getWriter();
	        out.println("<script>alert('�α��� ����!');history.go(-1);</script>");
	        mav.setViewName("redirect:login.jsp");
	        // DS -> HM -> C -> VR
	        // VR�� ��θ� �ϼ� ������ ���̱� ������
	        // .jsp/.do �� �� �ʿ����  ��Ʈ�ѷ��� ��ġ�� �ʰ� ���� 
		}
		return mav;
	}

	

}
