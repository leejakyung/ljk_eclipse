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
		
		System.out.println("���� �׼� ����" + cVO.getEmail());

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
			// ������ ���� ���� mcontent�� �־���  
			cVO.setUserPW(mcontent);
			// ������Ʈ
			cDAO.UpdatePW(cVO);

			System.out.println(mcontent);
			
			return "redirect:login.jsp";

		}

	}

}
/*
redirect VS forward
������ ����xxx   ������ ����

.do->Ŭ���̾�Ʈ�� ��û
.jsp->V(consoleâ ����)

 */
