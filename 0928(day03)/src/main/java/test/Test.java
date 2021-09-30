package test;

public class Test {
	// int a;
	public Test() {
		System.out.println("기본 생성자 호출됨!");
	}
	public void print() {
		System.out.println("출력");
	}
	
	public void initFunc() { // 초기화에 관련된 함수 
		System.out.println("멤버 변수를 초기화하는 코드 작성 가능!");
		// a=100;
	}
}