package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

// service �α��̳� �׼ǿ� ���Ǵ� ������̼� 
@Service // ������ ������ִ°� component(== �� �����ȿ� ���� �ִ°�) service(== ���� �ȿ� ������ ������ �־��ִ°�)  
@Aspect // �Ʒ��� ����Ʈ�ư� �Լ�(printLog)�� ���� �ִ°�  ex) ? �Լ����� ? ����Ʈ ���� ���ڴ�!!
public class AfterAdvice {

	@After("PointcutCommon.bPointcut()") // �ٽɰ��� == ����Ͻ��޼���, CRUD
	public void printLog(JoinPoint jp){ // ==advice
		Object[] args = jp.getArgs();
		String name= jp.getSignature().getName();
		
		System.out.println("�޼����: "+name);
		System.out.println("�Ű���������: "+args[0]);
		System.out.println("�ٽɰ��� �Ŀ� ȣ��!");
		
	}
	
}
