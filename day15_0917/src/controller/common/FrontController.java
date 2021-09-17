package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.DeleteMsgAction;
import controller.action.DeleteRpAction;
import controller.action.FvMsgAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.NewUserAction;
import controller.action.NewmsgAction;
import controller.action.NewrpAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) ������� ��û�� �м�
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());
		
		ActionForward forward=null; // null���� �׻� �־������?
		// 2) ��Ʈ�ѷ��� ����
		if(action.equals("/main.do")) { // ����
			forward=new MainAction().execute(request, response);
		}
		else if(action.equals("/login.do")) { // �α���
			forward=new LoginAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) { // �α׾ƿ�
			System.out.println("�α׾ƿ�Ȯ��");
			forward=new LogoutAction().execute(request, response);
		}
		else if(action.equals("/newrp.do")) { // ���� �߰�
			forward=new NewrpAction().execute(request, response);
		}
		else if(action.equals("/newmsg.do")) { // �Խñ� �߰�
			forward=new NewmsgAction().execute(request, response); 
		}
		else if(action.equals("/deletemsg.do")) { // �Խñ� ����
			forward=new DeleteMsgAction().execute(request, response);
		}
		else if(action.equals("/deleterp.do")) { // ���� ����
			forward=new DeleteRpAction().execute(request, response);
		}
		else if(action.equals("/newuser.do")) { // ȸ������
			forward=new NewUserAction().execute(request, response);
		}
		else if(action.equals("/fvmsg.do")) { // ���ƿ�
			forward=new FvMsgAction().execute(request, response);
		}
		else {
			 // ���� �������� ����
			forward=new ActionForward();
			forward.setRedirect(false);
			// ��κ� false �� �� . ������ � ������ ������ �м��� ���̱� ������?
			forward.setPath("/error/error404.jsp");
		}
		
		// 3) ����ڿ��� ��� ȭ�� ���
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}
}
