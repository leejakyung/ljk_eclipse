package test;

public class Benz implements Car{

	public Benz() {
		System.out.println("���� �⺻������ ȣ���!");
	}
	

	@Override
	public void ON() {
		System.out.println("���� �õ��ѱ�");
	}

	@Override
	public void OFF() {
		System.out.println("���� �õ�����");
	}


	@Override
	public void speedUp() {
		System.out.println("���� speed++");
	}


	@Override
	public void speedDown() {
		System.out.println("���� speed--");
	}

}
