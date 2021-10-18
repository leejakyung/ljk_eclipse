package controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 클라이언트의 요청 정보를 추출 
    	String uri=request.getRequestURI();
    	String cp=request.getContextPath();
    	String action=uri.substring(cp.length());
    	
    	ActionForward forward=null;
    	
    	/*if(action.equals("/main.do")) {
    		forward=new MainAction().execute(request, response);
    	}*/
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
		// UTF-8. 인코딩 설정 필요! 필터로 해줘도 됨
		doAction(request, response);
	}
	

}
