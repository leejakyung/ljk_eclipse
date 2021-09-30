package test;

public class IPhone implements Phone{

	private Watch watch;
	private int num;
	// ex) 아이폰에 List로 만든 전화번호부
	
	
	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public IPhone() { 
		System.out.println("아이폰 기본생성자 호출됨");
	}

	@Override
	public void powerOn() {
		System.out.println("아이폰 전원ON"+num);
	}

	@Override
	public void powerOff() {
		System.out.println("아이폰 전원OFF");
		
	}

	@Override
	public void volumeUp() {
		watch.volumeUp();
		//System.out.println("아이폰 소리++");
		
	}

	@Override
	public void volumeDown() {
		watch.volumeDown();
		//System.out.println("아이폰 소리--");
	}
	
}
