package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* model.board2.*Impl.get*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board2.*Impl.*(..))")
	public void bPointcut() {}
	
	@Pointcut("execution(* model..*Impl.*(..))")
	public void cPointcut() {}
	
	@Pointcut("execution(* model.member2.*Impl.get*(..))")
	public void dPointcut() {}
		
}
