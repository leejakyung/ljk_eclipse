package test;

public class CoffeeBean {
	private String coffeeName;
	private int num;
	private int result;  
	public CoffeeBean() {
		this.coffeeName="";
		this.result=0; 
		this.num=0;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result; 
	}


	public void coffeeOrder() {
		if(this.coffeeName.equals("¾Æ¸Þ¸®Ä«³ë")) {
			this.result=2000*this.num;
		} 
		else if(this.coffeeName.equals("Ä«Æä¶ó¶¼")) {
			this.result=2500*this.num;
		}
		else if(this.coffeeName.equals("¹Ù´Ò¶ó¶ó¶¼")) {
			this.result=3000*this.num;
		}
		else if(this.coffeeName.equals("µ¹Ã¼¶ó¶¼")) {
			this.result=4000*this.num;
		}
	}
}
