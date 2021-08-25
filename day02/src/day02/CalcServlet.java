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
		// ���� ������� ȭ�鿡 ��Ÿ��
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �����ϰ� �ٹ������ ����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		// string���� ���� �ѱ�� ������ integer.parseint�� ��ȯ
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("op");
		
		//int result=calc(num1,num2,op); // ���� ���ο� �޼��带 �а�  -> ������ �������
		// �Ʒ� ������� �ٲ���.
		Calc calc= new Calc(num1,num2,op);
		int result = calc.getResult();

		// ����ڰ� �����ϴ� �������� �̷��� ������ְڴ�.
		out.println("<HTML>"); 
		out.println("<head><title>���� ����</title></head>");
		out.println("<body>");
		out.println("<h2>�����: ");
		out.println(num1+""+op+""+num2+" = "+result);
		out.println("</h2>");
		out.println("</body></HTML>");
	}
	
	

}
