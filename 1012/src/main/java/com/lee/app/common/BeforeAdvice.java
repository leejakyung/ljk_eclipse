package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	
	@Before("PointcutCommon.dPointcut()")
	public void printLog(JoinPoint jp){
		Object[] args = jp.getArgs();
		String name= jp.getSignature().getName();
		
		System.out.println("메서드명: "+name);
		System.out.println("매개변수정보: "+args[0]); //vo
		System.out.println("핵심관심 전에 호출!");
		
	}
}
