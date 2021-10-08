package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// 로깅 처리를 할 때마다 사용할 메서드
@Service
@Aspect
public class LogAdvice {
	

	
	@Before("PointcutCommon.aPointcut()")
	public void printLog() {
		System.out.println("비즈니스 메서드를 수행하기 전에 출력되는 로그!");
		// 응집도가 높다!
	}	
}
// 1. get*() 수행시에만
// 2. 해당 핵심관심 이전에 수행될 수 있도록
// 3. LogAdvice의 printLog()가