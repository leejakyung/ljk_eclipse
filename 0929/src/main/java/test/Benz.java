package test;

public class Benz implements Car{

	public Benz() {
		System.out.println("º¥Ã÷ ±âº»»ý¼ºÀÚ È£ÃâµÊ!");
	}
	

	@Override
	public void ON() {
		System.out.println("º¥Ã÷ ½Ãµ¿ÄÑ±â");
	}

	@Override
	public void OFF() {
		System.out.println("º¥Ã÷ ½Ãµ¿²ô±â");
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
