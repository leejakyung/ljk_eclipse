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


		//out.println("글자크기, 색 넣는 커스텀태그 실습!");
		// <p style = 'font-size:50px; color:pink;'>
		StringBuffer sb=new StringBuffer();
		sb.append("<p style ='font-size:").append(size).append("; color:").append(color).append(";'>");
		System.out.println(sb.toString());
		// out.println(sb.toString());
		JspFragment body=getJspBody();
		if(body!=null) { // 바디가 null이면 안댐 그렇기 때문에 if문이 있는것 !!! 
			body.invoke(null); // 현재상황에서 캡슐화를 해준것 ...? 무엇을 넣을지 모르기 때문? 
		}
		out.println("</p>");
	}




}
