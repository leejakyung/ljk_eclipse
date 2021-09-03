package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ColorTagHandler extends SimpleTagSupport{

	private String color;
	private String size;



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}




	public void doTag() throws IOException, JspException{
		JspWriter out=getJspContext().getOut();


		//out.println("����ũ��, �� �ִ� Ŀ�����±� �ǽ�!");
		// <p style = 'font-size:50px; color:pink;'>
		StringBuffer sb=new StringBuffer();
		sb.append("<p style ='font-size:").append(size).append("; color:").append(color).append(";'>");
		System.out.println(sb.toString());
		// out.println(sb.toString());
		JspFragment body=getJspBody();
		if(body!=null) { // �ٵ� null�̸� �ȴ� �׷��� ������ if���� �ִ°� !!! 
			body.invoke(null); // �����Ȳ���� ĸ��ȭ�� ���ذ� ...? ������ ������ �𸣱� ����? 
		}
		out.println("</p>");
	}




}
