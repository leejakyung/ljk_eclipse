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
		
		System.out.println("�޼����: "+name);
		System.out.println("�Ű���������: "+args[0]); //vo
		System.out.println("�ٽɰ��� ���� ȣ��!");
		
	}
}
