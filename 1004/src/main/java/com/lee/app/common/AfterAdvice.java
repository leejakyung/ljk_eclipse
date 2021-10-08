package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class AfterAdvice {
	// 애스팩트(실시간 위빙처리)
	// 어드바이스+포인트컷
	
	// 참조 메서드
	// 어드바이스가 포인트컷을  "식별"하기 위해 작성 
	// 로직은 작성할 필요xxx. {}바디 블럭이 비어있음

	
	@After("PointcutCommon.bPointcut()")
	public void printLog(JoinPoint jp) {
		Object[] args= jp.getArgs();
		String name= jp.getSignature().getName(); // 이 라인에 쓴 폼이 많이 보이는 편
		
		System.out.println("메서드명: "+name);
		System.out.println("매개변수정보: "+args[0]);
		System.out.println("핵심관심 후에 호출됨");
	}
}
