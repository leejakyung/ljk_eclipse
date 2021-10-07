package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

import model.memmem.MemmemVO;

public class AfterReturningAdvice {
	public void printLog(JoinPoint jp,Object obj) { //Object도 바인드 변수
		String name=jp.getSignature().getName();
		System.out.println("메서드명: "+name);
		if(obj instanceof MemmemVO) { //멤버VO로 캐스팅이 가능한지 먼저 확인
			MemmemVO data=(MemmemVO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("관리자 로그인");
			} else {
				System.out.println("일반 사용자 로그인");
			}
		}
		System.out.println("get()와 조합되는 returning");
	}
}
