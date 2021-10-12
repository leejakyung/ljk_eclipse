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
		System.out.println("메서드명: "+name);
		if(obj instanceof Member2VO) {
			Member2VO data = (Member2VO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("관리자로그인!");
			} else {
				System.out.println("사용자로그인!");
			}
		}
		System.out.println("get()와 조합되는 returning");
	}
}
