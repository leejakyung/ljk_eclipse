package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class AfterAdvice {
	// �ֽ���Ʈ(�ǽð� ����ó��)
	// �����̽�+����Ʈ��
	
	// ���� �޼���
	// �����̽��� ����Ʈ����  "�ĺ�"�ϱ� ���� �ۼ� 
	// ������ �ۼ��� �ʿ�xxx. {}�ٵ� ���� �������

	
	@After("PointcutCommon.bPointcut()")
	public void printLog(JoinPoint jp) {
		Object[] args= jp.getArgs();
		String name= jp.getSignature().getName(); // �� ���ο� �� ���� ���� ���̴� ��
		
		System.out.println("�޼����: "+name);
		System.out.println("�Ű���������: "+args[0]);
		System.out.println("�ٽɰ��� �Ŀ� ȣ���");
	}
}
