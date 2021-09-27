package day02;

public class BeanFactory {
	// 빈즈클래스
	// DAO VO 
	// <jsp:useBean DAO>
	// 비즈니스 메서드를 갖고 있는 객체 
	// == 모듈
	
	public Object getBean(String beanName) {
		if(beanName.equals("Ga")) {
			return new GaPhone();
		}
		else if(beanName.equals("I")) {
			return new IPhone();
		}
		
		return null;
	}
}