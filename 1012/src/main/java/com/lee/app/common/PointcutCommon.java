package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* model.board2.*Impl.get*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board2.*Impl.*(..))")
	public void bPointcut() {}
	
	@Pointcut("execution(* model..*Impl.*(..))") // board2, member2 모두 받아옴 , 모든 client에게 포인트컷을 적용시키기 위해 만든 포인트컷
	public void cPointcut() {}
	
	@Pointcut("execution(* model.member2.*Impl.get*(..))") // memeber2에 get만 받아옴
	public void dPointcut() {}
		
}
