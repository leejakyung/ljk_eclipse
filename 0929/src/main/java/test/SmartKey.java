package test;

public class SmartKey implements Key{

	public SmartKey() {
		System.out.println("����ƮŰ �⺻������ ȣ���!!");
	}
	
	@Override
	public void ON() {
		System.out.println("����ƮŰ�� �õ��ѱ�");
	}

	@Override
	public void OFF() {
		System.out.println("����ƮŰ�� �õ�����");
	}

}
