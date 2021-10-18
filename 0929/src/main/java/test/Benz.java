package test;

public class Benz implements Car{
	


	private Key key;
	private String user;

	public Benz() {
		System.out.println("º¥Ã÷ ±âº»»ý¼ºÀÚ È£ÃâµÊ!");
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
		//System.out.println("º¥Ã÷ ½Ãµ¿ÄÑ±â");
	}

	@Override
	public void OFF() {
		key.OFF();
		//System.out.println("º¥Ã÷ ½Ãµ¿²ô±â");
	}


	@Override
	public void speedUp() {
		System.out.println("º¥Ã÷ speed++");
	}


	@Override
	public void speedDown() {
		System.out.println("º¥Ã÷ speed--");
	}

}
