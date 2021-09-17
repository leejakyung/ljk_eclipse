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
		// 1) 사용자의 요청을 분석
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());
		
		ActionForward forward=null; // null값을 항상 넣어줘야함?
		// 2) 컨트롤러랑 매핑
		if(action.equals("/main.do")) { // 메인
			forward=new MainAction().execute(request, response);
		}
		else if(action.equals("/login.do")) { // 로그인
			forward=new LoginAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) { // 로그아웃
			System.out.println("로그아웃확인");
			forward=new LogoutAction().execute(request, response);
		}
		else if(action.equals("/newrp.do")) { // 대댓글 추가
			forward=new NewrpAction().execute(request, response);
		}
		else if(action.equals("/newmsg.do")) { // 게시글 추가
			forward=new NewmsgAction().execute(request, response); 
		}
		else if(action.equals("/deletemsg.do")) { // 게시글 삭제
			forward=new DeleteMsgAction().execute(request, response);
		}
		else if(action.equals("/deleterp.do")) { // 대댓글 삭제
			forward=new DeleteRpAction().execute(request, response);
		}
		else if(action.equals("/newuser.do")) { // 회원가입
			forward=new NewUserAction().execute(request, response);
		}
		else if(action.equals("/fvmsg.do")) { // 좋아요
			forward=new FvMsgAction().execute(request, response);
		}
		else {
			 // 에러 페이지랑 연결
			forward=new ActionForward();
			forward.setRedirect(false);
			// 대부분 false 를 씀 . 앞으로 어떤 에러가 들어올지 분석할 것이기 때문에?
			forward.setPath("/error/error404.jsp");
		}
		
		// 3) 사용자에게 결과 화면 출력
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}
}
