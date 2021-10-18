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
@WebFilter("*.jsp") //�� ������ ��� .jsp�� ���Ϸ��� ���� ���� �������� 
// �������� ȣ��Ǳ����� filter �������� ���ļ� ������
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
    // ���� -> ��Ĺ�� ������ �����
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.encoding); // ���� ��Ʈ�ѿ��� �ϴ� ������ ���⼭�� 
		chain.doFilter(request, response); // ���� ü���� ������ �˾Ƽ� ���������� �̵���
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	// �ʱ����
	public void init(FilterConfig fConfig) throws ServletException {
		this.encoding=fConfig.getServletContext().getInitParameter("encoding");
	}
	// �ܺ����� web.xml���� ����س��� �ʱ�ȭ �Ű����� ��(==UTF-8)��
	// ��������� ������
}
