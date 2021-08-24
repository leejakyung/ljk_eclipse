package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test")
public class Test extends HttpServlet {
   private static final long serialVersionUID = 1L;
   // 객체 직렬화
   // 자바내 클래스의 상태 정보를 파일로 저장하는 방법
   // 필요할 때 다시 객체화하여 메서드,멤버를 이용할수있게됨
    
   
    public Test() { // 기본생성자를 반드시 필요로함
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //response.getWriter().append("Served at: ").append(request.getContextPath());
   
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out=response.getWriter();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>서블릿 예제</TITLE><HEAD>");
      out.println("<BODY><H1>서블릿 실습이다!~~</H1></BODY>");
      out.println("</HTML>");
      
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
      // Post방식으로 요청해도, Get으로 처리하겠다~
   }

}