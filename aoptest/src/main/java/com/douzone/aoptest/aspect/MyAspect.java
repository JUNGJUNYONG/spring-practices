package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("-------- before advice --------");
	}
	
	@After("execution(* *..*.service.ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("-------- after advice --------");
	}
	
	@AfterReturning("execution(* *..*.service.ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("-------- afterReturning advice --------");
	}
	
	@AfterThrowing(value = "execution(* *..*.*.*(..))", throwing = "ex")
	public void afterThrowingAdvice() {
		System.out.println("-------- afterThrowingAdvice advice --------");
	}
	
	@Around("execution(* *..*.service.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		// before advice
		System.out.println("@Around(before) Advice");
		// PointCut Method 실행
		
		// 파라미터 가로채기(바꿔버리기)
		//Object[] params = {"Camera"};
		//Object result = pjp.proceed(params);
		Object result = pjp.proceed();
		
		// after advice
		System.out.println("@Around(after) Advice");
		
		return result;
	}
}
