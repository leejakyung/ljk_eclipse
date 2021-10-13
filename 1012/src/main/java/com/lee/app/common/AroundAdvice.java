package com.lee.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointcutCommon.cPointcut()") 
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("pjp인자를 갖는 메서드에서 출력하는 문구 -1");
		System.out.println("메서드명: "+pjp.getSignature().getName());
		StopWatch sw=new StopWatch();
		
		sw.start();
		
		Object obj=pjp.proceed(); // == 비즈니스메서드 가 이곳에서 실행될 것이라고 선언 
		
		sw.stop();
		
		System.out.println("소요시간: "+sw.getTotalTimeMillis());
		System.out.println("pjp인자를 갖는 메서드에서 출력하는 문구 -2");
		return obj;
	}
	
}