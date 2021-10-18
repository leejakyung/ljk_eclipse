package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

// service 로깅이나 액션에 사용되는 어노테이션 
@Service // 목차를 만들어주는것 component(== 한 폴더안에 전부 넣는것) service(== 폴더 안에 폴더로 나눠서 넣어주는것)  
@Aspect // 아래의 포인트컷과 함수(printLog)를 묶어 주는것  ex) ? 함수에는 ? 포인트 컷을 쓰겠다!!
public class AfterAdvice {

	@After("PointcutCommon.bPointcut()") // 핵심관심 == 비즈니스메서드, CRUD
	public void printLog(JoinPoint jp){ // ==advice
		Object[] args = jp.getArgs();
		String name= jp.getSignature().getName();
		
		System.out.println("메서드명: "+name);
		System.out.println("매개변수정보: "+args[0]);
		System.out.println("핵심관심 후에 호출!");
		
	}
	
}
