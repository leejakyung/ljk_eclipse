package test;

public class GaPhone implements Phone {
	
	private Watch watch;
	private String user;
	
	public GaPhone() { 
		System.out.println("������ �⺻������ ȣ���");
	}
	
	public GaPhone(Watch watch, String user) {
		this.watch=watch;
		this.user=user;
		System.out.println("������ ������ ȣ���");
	}
	
	@Override
	public void powerOn() {
		System.out.println("������ ����ON");
		
	}

	@Override
	public void powerOff() {
		System.out.println("������ ����OFF");
	}

	@Override
	public void volumeUp() {
		watch.volumeUp();
		// System.out.println("������ �Ҹ�++");
	}

	@Override
	public void volumeDown() {
		watch.volumeDown();
		// System.out.println("������ �Ҹ�--");
	}

}
