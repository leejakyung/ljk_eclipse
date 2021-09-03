package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.DataBean;

public class MsgTagHandler extends SimpleTagSupport {
	private String bgcolor;
	private String border;

	public void doTag() throws IOException, JspException {
		JspWriter out=getJspContext().getOut();

		JspFragment body=getJspBody();
		if(body!=null) { // 바디가 null이면 안댐 그렇기 때문에 if문이 있는것 !!! 
			out.println("<h1>");
			body.invoke(null);
			out.println("</h1>");
		}

		DataBean db=new DataBean();

		// out 내장객체를 일을 덜 시키기 위해? -> 스트링버퍼를 이용해보자! 
		StringBuffer sb=new StringBuffer();
		sb.append("<table border=").append(border).append(" bgcolor=").append(bgcolor).append(">");
		/*
		out.println("<table border=");
		out.println(border);
		out.println(" bgcolor="); //앞에 띄어쓰기
		out.println(bgcolor);
		out.println(">");
		 */
		out.println(sb.toString());
		for(String v:db.getDataList()) {
			out.println("<tr><td>"+v+"</td></tr>");
		}
		out.println("</table>");
	}

	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	public String getBorder() {
		return border;
	}
	public void setBorder(String border) {
		this.border = border;
	}

}
