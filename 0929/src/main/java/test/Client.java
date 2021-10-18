package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {

		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		Car car=(Car)factory.getBean("car");
		car.ON();
		car.speedUp();
		
		
		CarBean cb=(CarBean)factory.getBean("cb");
		List<String> list=cb.getList();
		for(String v:list) {
			System.out.println(v);
		}
		
		CarBean cbm=(CarBean)factory.getBean("cbm");
		Map<String,String> map=cbm.getMap();
		System.out.println(map);
		
		
		factory.close();
	}
}
