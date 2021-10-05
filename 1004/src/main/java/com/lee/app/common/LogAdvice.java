package com.lee.app.common;

// 로깅 처리를 할 때마다 사용할 메서드
public class LogAdvice {
	public void printLog() {
		System.out.println("비즈니스 메서드를 수행하기 전에 출력되는 로그!");
		// 응집도가 높다!
	}	
}