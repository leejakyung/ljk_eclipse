package test;

public class NormalKey implements Key{

	public NormalKey() {
		System.out.println("�Ϲ�Ű �⺻������ ȣ���!");
	}
	
	@Override
	public void ON() {
		System.out.println("�Ϲ�Ű�� �õ��ѱ�");
	}

	@Override
	public void OFF() {
		System.out.println("�Ϲ�Ű�� �õ�����");
	}

}
