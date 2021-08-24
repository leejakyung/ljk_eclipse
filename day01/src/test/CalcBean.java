package test;

public class CalcBean {

   private int num1;
   private int num2;
   private String op;
   private int result;
   public CalcBean(){
      this.op="";
      this.result=0;
   }
   
   public int getResult() {
      return result;
   }
   public void setResult(int result) {
      this.result = result;
   }
   public int getNum1() {
      return num1;
   }
   public void setNum1(int num1) {
      this.num1 = num1;
   }
   public int getNum2() {
      return num2;
   }
   public void setNum2(int num2) {
      this.num2 = num2;
   }
   public String getOp() {
      return op;
   }
   public void setOp(String op) {
      this.op = op;
   }
   
   
   
   
   // ±â´É
   public void calculate() {
      if(this.op.equals("+")) {
         this.result=this.num1+this.num2;
      }
      else if(this.op.equals("-")) {
         this.result=this.num1-this.num2;
      }
   }
   
   
 
   
}