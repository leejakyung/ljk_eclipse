package test;

public class Benz implements Car{
	


	private Key key;
	private String user;

	public Benz() {
		System.out.println("���� �⺻������ ȣ���!");
	}
	
	
	public void setKey(Key key) {
		this.key = key;
	}
	
	
	public void setUser(String user) {
		this.user = user;
	}
	
	@Override
	public void ON() {
		key.ON();
		//System.out.println("���� �õ��ѱ�");
	}

	@Override
	public void OFF() {
		key.OFF();
		//System.out.println("���� �õ�����");
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
