package test;

public class GaPhone implements Phone {
	
	private Watch watch;
	private String user;
	
	public GaPhone() { 
		System.out.println("갤럭시 기본생성자 호출됨");
	}
	
	public GaPhone(Watch watch, String user) {
		this.watch=watch;
		this.user=user;
		System.out.println("갤럭시 생성자 호출됨");
	}
	
	@Override
	public void powerOn() {
		System.out.println("갤럭시 전원ON");
		
	}

	@Override
	public void powerOff() {
		System.out.println("갤럭시 전원OFF");
	}

	@Override
	public void volumeUp() {
		watch.volumeUp();
		// System.out.println("갤럭시 소리++");
	}

	@Override
	public void volumeDown() {
		watch.volumeDown();
		// System.out.println("갤럭시 소리--");
	}

}
