package day02;

public class Calc {
	
	int result;
	
	public Calc(int num1,int num2,String op) { //�ٸ������� ���Ÿ� public
	/*
	 ���ɺи�
 	: concern �и�
  	-> ����� ���ε��� ����
   	== ���� ����
   	== �������� ��
 	��ɺ����� Ŭ�������� -> ���==������Ʈ == ���� : M
	 */
		// ����� �ۼ��Ϸ��� else if�� ...
		if(op.equals("+")) {
			result=num1+num2;
		}
		else {
			result=num1-num2;
		}
		
	}
	
	// get �� �ʿ��ؼ� �ʿ���°� ���� ���� 
	public int getResult() {
		return result;
	}
	
	
	
}
