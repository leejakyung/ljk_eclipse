package test;

public class SmartKey implements Key{

	public SmartKey() {
		System.out.println("스마트키 기본생성자 호출됨!!");
	}
	
	@Override
	public void ON() {
		System.out.println("스마트키로 시동켜기");
	}

	@Override
	public void OFF() {
		System.out.println("스마트키로 시동끄기");
	}

}
