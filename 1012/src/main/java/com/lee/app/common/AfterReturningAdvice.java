package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import model.member2.Member2VO;

@Service
@Aspect
public class AfterReturningAdvice {

	@AfterReturning(pointcut="PointcutCommon.cPointcut()", returning="obj")
	public void printLog(JoinPoint jp,Object obj) {
		String name=jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		if(obj instanceof Member2VO) {
			Member2VO data = (Member2VO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("�����ڷα���!");
			} else {
				System.out.println("����ڷα���!");
			}
		}
		System.out.println("get()�� ���յǴ� returning");
	}
}
