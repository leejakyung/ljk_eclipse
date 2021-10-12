package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	
	public void printLog(JoinPoint jp, Exception excep) {
		String name=jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		System.out.println("����: "+excep);
		
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("�Ű������� �������� �ʽ��ϴ�."); // � �������� �˷���
		} else if(excep instanceof ArithmeticException) {
			System.out.println("0���� ���� �� �����ϴ�.");
		} else if(excep instanceof Exception) {
			System.out.println("��Ȯ�� ����");
		}
		
		System.out.println("���� �߻� �� ȣ��");
		
	}
}
