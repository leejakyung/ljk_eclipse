package test;

public class Client {
	public static void main(String[] args) {
		BeanFactory factory= new BeanFactory();
		TV tv=(TV)factory.getBean(args[1]); // �Ｚ[0], LG[1]
		tv.volumeUp();
		tv.powerOff();
	}
}
