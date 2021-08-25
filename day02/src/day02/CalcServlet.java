package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 위의 방법으로 화면에 나타냄
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 무시하고 겟방식으로 보냄
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		// string으로 값을 넘기기 때문에 integer.parseint로 변환
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("op");
		
		//int result=calc(num1,num2,op); // 서블릿 내부에 메서드를 둔것  -> 협업이 어려워짐
		// 아래 방법으로 바꿔줌.
		Calc calc= new Calc(num1,num2,op);
		int result = calc.getResult();

		// 사용자가 응답하는 페이지에 이렇게 출력해주겠다.
		out.println("<HTML>"); 
		out.println("<head><title>계산기 서블릿</title></head>");
		out.println("<body>");
		out.println("<h2>계산결과: ");
		out.println(num1+""+op+""+num2+" = "+result);
		out.println("</h2>");
		out.println("</body></HTML>");
	}
	
	

}
