package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

import model.memmem.MemmemVO;

public class AfterReturningAdvice {
	public void printLog(JoinPoint jp,Object obj) { //Object�� ���ε� ����
		String name=jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		if(obj instanceof MemmemVO) { //���VO�� ĳ������ �������� ���� Ȯ��
			MemmemVO data=(MemmemVO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			} else {
				System.out.println("�Ϲ� ����� �α���");
			}
		}
		System.out.println("get()�� ���յǴ� returning");
	}
}
