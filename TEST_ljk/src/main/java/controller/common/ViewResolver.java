package controller.common;

public class ViewResolver { // view로 가게 해주는 주체
	// setter로 초기화
	
	/* == public String head;
	      public String tail; 
	      머릿말과 꼬릿말 정도로 이해할 것*/
	
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
