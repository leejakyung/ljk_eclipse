package day13;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter("*.jsp") //★ 앞으로 모든 .jsp로 향하려면 나를 먼저 지나가라 
// 페이지가 호출되기전에 filter 페이지를 거쳐서 지나감
public class TestFilter implements Filter {

	private String encoding;
	
    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    // 해제 -> 톰캣이 꺼질때 종료됨
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.encoding); // 원래 컨트롤에서 하는 역할을 여기서함 
		chain.doFilter(request, response); // 다음 체인이 없으면 알아서 종착역으로 이동함
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	// 초기생성
	public void init(FilterConfig fConfig) throws ServletException {
		this.encoding=fConfig.getServletContext().getInitParameter("encoding");
	}
	// 외부파일 web.xml에서 등록해놓은 초기화 매개변수 값(==UTF-8)을
	// 멤버변수로 가져옴
}
