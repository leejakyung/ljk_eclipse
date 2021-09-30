package test;

public class IPhone implements Phone{

	private Watch watch;
	private int num;
	// ex) �������� List�� ���� ��ȭ��ȣ��
	
	
	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public IPhone() { 
		System.out.println("������ �⺻������ ȣ���");
	}

	@Override
	public void powerOn() {
		System.out.println("������ ����ON"+num);
	}

	@Override
	public void powerOff() {
		System.out.println("������ ����OFF");
		
	}

	@Override
	public void volumeUp() {
		watch.volumeUp();
		//System.out.println("������ �Ҹ�++");
		
	}

	@Override
	public void volumeDown() {
		watch.volumeDown();
		//System.out.println("������ �Ҹ�--");
	}
	
}
