package test;

public class SmartWatch implements Watch{

	public SmartWatch() { 
		System.out.println("����Ʈ��ġ �⺻������ ȣ���");
	}
	@Override
	public void volumeUp() {
		System.out.println("����Ʈ��ġ�� �Ҹ���!");
	}

	@Override
	public void volumeDown() {
		System.out.println("����Ʈ��ġ�� �Ҹ��ٿ�!");
	}

}
