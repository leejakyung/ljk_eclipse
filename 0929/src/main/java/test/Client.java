package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {

		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		Car car=(Car)factory.getBean("car");
		car.ON();
		car.speedUp();
		
		factory.close();
		
		
	}
}
