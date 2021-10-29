package controller.action;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.client2.Client2DAO;
import model.client2.Client2VO;
import web.mail.MailSend;

@Controller
public class MailController {
	
	@RequestMapping("/pwmail.do")
	public String mail(HttpServletRequest request, Client2VO cVO,Client2DAO cDAO) {
		
		System.out.println("메일 액션 도착" + cVO.getEmail());

		String email = request.getParameter("email");
		

		// public MemVO SelectOne(MemVO vo) {
		//mVO.setMid(mid);

		if (cDAO.SelectOne(cVO) == null) {
			/*PrintWriter out = response.getWriter();
			out.println("<script>alert('false');history.go(-1);</script>");*/
			
			return "pw.jsp";
		} else {
			MailSend sender = new MailSend();
			String mcontent = sender.MailSend(cVO.getEmail()); 
			// 생성된 난수 값을 mcontent에 넣어줌  
			cVO.setUserPW(mcontent);
			// 업데이트
			cDAO.UpdatePW(cVO);

			System.out.println(mcontent);
			
			return "redirect:login.jsp";

		}

	}

}
/*
redirect VS forward
데이터 유지xxx   데이터 유지

.do->클라이언트의 요청
.jsp->V(console창 역할)

 */
