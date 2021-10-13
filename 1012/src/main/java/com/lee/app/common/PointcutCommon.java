package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* model.board2.*Impl.get*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board2.*Impl.*(..))")
	public void bPointcut() {}
	
	@Pointcut("execution(* model..*Impl.*(..))") // board2, member2 ��� �޾ƿ� , ��� client���� ����Ʈ���� �����Ű�� ���� ���� ����Ʈ��
	public void cPointcut() {}
	
	@Pointcut("execution(* model.member2.*Impl.get*(..))") // memeber2�� get�� �޾ƿ�
	public void dPointcut() {}
		
}
