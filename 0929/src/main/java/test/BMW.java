package test;

public class BMW implements Car{

	private Key key;
	private String user;
	
	public BMW() {
		System.out.println("BMW �⺻������ ȣ���!");
	}
	
	public BMW(Key key, String user) {
		this.key=key;
		this.user=user;
		System.out.println("BMW ������ ȣ���"+this.user);
	}

	@Override
	public void ON() {
		key.ON();
		//System.out.println("BMW �õ��ѱ�");
	}

	@Override
	public void OFF() {
		key.OFF();
		//System.out.println("BMW �õ�����");
	}


	@Override
	public void speedUp() {
		System.out.println("BMW speed++");
	}


	@Override
	public void speedDown() {
		System.out.println("BMW speed--");
	}

}
