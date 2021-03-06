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
//	@Pointcut("bean(*ker)") // *ker로 끝나는 이름을 가진 빈에만 advice 적용
	@Pointcut("bean(student)")
	private void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()")
	public  Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr = joinPoint.getSignature().toShortString();
		//타겟 메서드의 signature 정보
		System.out.println(signatureStr + "메서드가 시작 되었습니다.");
		long st = System.currentTimeMillis();//메서드 호출전의 현재 시간
	
		try {
		Object obj = joinPoint.proceed();//타겟의 메서드 호출
		return obj;
		} finally {
			long et = System.currentTimeMillis();//메서드 호출후의 현재 시간
			System.out.println(signatureStr + "메서드가 종료되었습니다.");
			System.out.println(signatureStr + "메서드의 작업 실행시간" + (et-st) + " ms");
		}
	}
	
	@Before("within(com.javaeunjeong.ex.*)")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("before Advice 실행!");
	}
	
	public void afterReturningAdvice(JoinPoint joinPoint) {
		System.out.println("afterReturningAdvice 실행!");
	}
	
	public void afterThrowAdvice(JoinPoint joinPoint) {
		System.out.println("afterThrowAdvice실행!");
	}
	
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("afterAdvice 실행!");
	}
	
	
}
