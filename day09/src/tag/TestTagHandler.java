package tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTagHandler extends SimpleTagSupport {
	
	// ���� �±��� ����� �����ϴ� �޼��� 
	// �����±׸� ������ �ڵ� ȣ���! 
	public void doTag() throws IOException { // �̸� ������ doTag�� ����ǰ� �Ǿ����� 
		// JSP�κ��� ������ �޾ƿ� �� �ְ� �ϴ� �޼���
		// getOut() <- ���帹�̾��� : out ��ü�� �����Ҷ� ���
		JspWriter out=getJspContext().getOut();
		out.println("�±� �ڵ鷯 Ŭ������� �ǽ���!");
	}
	
}
