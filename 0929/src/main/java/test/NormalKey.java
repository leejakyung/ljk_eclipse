package test;

public class NormalKey implements Key{

	public NormalKey() {
		System.out.println("일반키 기본생성자 호출됨!");
	}
	
	@Override
	public void ON() {
		System.out.println("일반키로 시동켜기");
	}

	@Override
	public void OFF() {
		System.out.println("일반키로 시동끄기");
	}

}
