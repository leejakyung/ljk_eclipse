package test;

public class BMW implements Car{

	private Key key;
	private String user;
	
	public BMW() {
		System.out.println("BMW 기본생성자 호출됨!");
	}
	
	public BMW(Key key, String user) {
		this.key=key;
		this.user=user;
		System.out.println("BMW 생성자 호출됨"+this.user);
	}

	@Override
	public void ON() {
		key.ON();
		//System.out.println("BMW 시동켜기");
	}

	@Override
	public void OFF() {
		key.OFF();
		//System.out.println("BMW 시동끄기");
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
