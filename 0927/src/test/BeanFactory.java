package test;

public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("»ï¼º")) {
			return new SamsungTV();
		}
		else if(beanName.equals("LG")) {
			return new LGTV();
		}
		
		return null;
	}
}
