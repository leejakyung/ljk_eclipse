package test;

public class LGTV implements TV {
	@Override
	public void powerOn() {
		System.out.println("전원 켜기");
		
	}
	@Override
	public void powerOff() {
		System.out.println("전원 끄기");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("소리++");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("소리--");
		
	}

}
