package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	
	@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {}
	
	@Pointcut("execution(* model.memmem.*Impl.get*(..))")
	public void cPointcut() {}	
	
}
