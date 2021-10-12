package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	
	public void printLog(JoinPoint jp, Exception excep) {
		String name=jp.getSignature().getName();
		System.out.println("메서드명: "+name);
		System.out.println("예외: "+excep);
		
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("매개변수로 적절하지 않습니다."); // 어떤 오류인지 알려줌
		} else if(excep instanceof ArithmeticException) {
			System.out.println("0으로 나눌 수 없습니다.");
		} else if(excep instanceof Exception) {
			System.out.println("미확인 예외");
		}
		
		System.out.println("예외 발생 시 호출");
		
	}
}
