package controller.common;

public class ViewResolver { // view�� ���� ���ִ� ��ü
	// setter�� �ʱ�ȭ
	
	/* == public String head;
	      public String tail; 
	      �Ӹ����� ������ ������ ������ ��*/
	
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String view) {
		return prefix+view+suffix;
	}
}
