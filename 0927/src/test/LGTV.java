package test;

public class LGTV implements TV {
	@Override
	public void powerOn() {
		System.out.println("���� �ѱ�");
		
	}
	@Override
	public void powerOff() {
		System.out.println("���� ����");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("�Ҹ�++");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("�Ҹ�--");
		
	}

}
