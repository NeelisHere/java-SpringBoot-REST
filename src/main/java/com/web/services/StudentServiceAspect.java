package com.web.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentServiceAspect {
	@Before(value = "execution(* com.web.controllers.StudentController.*(..))")
	public void beforeAdvise(JoinPoint jp) {
		System.out.printf("Before running: %s\n", jp.getSignature());
	}
	
	@AfterReturning(value = "execution(* com.web.controllers.StudentController.*(..))")
	public void afterReturningAdvise(JoinPoint jp) {
		System.out.printf("after returning: %s\n", jp.getSignature());
	}
	
	@After(value = "execution(* com.web.controllers.StudentController.*(..))")
	public void afterAdvise(JoinPoint jp) {
		System.out.printf("after running: %s\n", jp.getSignature());
	}
	
//	@Around(value = "execution(* com.web.controllers.StudentController.*(..))")
//	public void aroundAdvise(ProceedingJoinPoint pjp) {
//		System.out.println("around...");
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			System.out.println("error");
//			e.printStackTrace();
//		}
//	}
}
