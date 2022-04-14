package com.javaeunjeong.ex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
//	@Pointcut("within(com.javaeunjeong.ex.*)")
//	@Pointcut("bean(*ker)") // *ker�� ������ �̸��� ���� �󿡸� advice ����
	@Pointcut("bean(student)")
	private void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()")
	public  Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr = joinPoint.getSignature().toShortString();
		//Ÿ�� �޼����� signature ����
		System.out.println(signatureStr + "�޼��尡 ���� �Ǿ����ϴ�.");
		long st = System.currentTimeMillis();//�޼��� ȣ������ ���� �ð�
	
		try {
		Object obj = joinPoint.proceed();//Ÿ���� �޼��� ȣ��
		return obj;
		} finally {
			long et = System.currentTimeMillis();//�޼��� ȣ������ ���� �ð�
			System.out.println(signatureStr + "�޼��尡 ����Ǿ����ϴ�.");
			System.out.println(signatureStr + "�޼����� �۾� ����ð�" + (et-st) + " ms");
		}
	}
	
	@Before("within(com.javaeunjeong.ex.*)")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("before Advice ����!");
	}
	
	public void afterReturningAdvice(JoinPoint joinPoint) {
		System.out.println("afterReturningAdvice ����!");
	}
	
	public void afterThrowAdvice(JoinPoint joinPoint) {
		System.out.println("afterThrowAdvice����!");
	}
	
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("afterAdvice ����!");
	}
	
	
}
