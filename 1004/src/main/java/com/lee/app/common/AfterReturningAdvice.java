package com.lee.app.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import model.memmem.MemmemVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	// pointcut=이 원래 생략되어 있는건데 바인드 변수가 존재 할때는 생략해서는 안됨!
	@AfterReturning(pointcut="PointcutCommon.cPointcut()", returning="obj")
	public void printLog(JoinPoint jp,Object obj) { //Object에 바인드 변수가 있음
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
