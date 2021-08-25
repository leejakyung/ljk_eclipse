package day02;

public class Calc {
	
	int result;
	
	public Calc(int num1,int num2,String op) { //다른곳에서 쓸거면 public
	/*
	 관심분리
 	: concern 분리
  	-> 기능을 따로따로 보관
   	== 협업 유리
   	== 유지보수 편리
 	기능보관한 클래스파일 -> 모듈==컴포넌트 == 빈즈 : M
	 */
		// 제대로 작성하려면 else if로 ...
		if(op.equals("+")) {
			result=num1+num2;
		}
		else {
			result=num1-num2;
		}
		
	}
	
	// get 만 필요해서 필요없는건 넣지 않음 
	public int getResult() {
		return result;
	}
	
	
	
}
