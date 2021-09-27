package day02;

public class Person {
	public static void main(String[] args) {
		BeanFactory factory=new BeanFactory();
		Phone phone=(Phone)factory.getBean(args[0]);
		phone.powerOn();
		phone.volumeDown();
		phone.volumeUp();
		phone.powerOff();
	}
}
