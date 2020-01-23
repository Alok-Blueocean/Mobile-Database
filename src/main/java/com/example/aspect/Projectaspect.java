package com.example.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.Entity.ProductDetails;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
public class Projectaspect {

	public Projectaspect() {
		System.out.println("\n\n|||\n aspect working\n\n");
	}

	@Pointcut("execution(public void setName*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()") //* setName*(..)
	public void beforeAddProductAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addProduct()");
	}
	
	@Before("forDaoPackage()") //* setName*(..)
	public void beforeAddProductAdviceWithArg(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(methodSignature);
		Object[] argObjects = joinPoint.getArgs();
		for (Object object : argObjects) {
			System.out.println(object);
			if (object instanceof String) {
				System.out.println(object);
			}
		}
	}
	
	@AfterReturning(pointcut = "execution(* getProduct*())",returning = "productDetails") //* setName*(..)
	public void afterReturningProduct(JoinPoint joinPoint,ProductDetails productDetails) {
		System.out.println("====> After Return ++++==========<");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(methodSignature);
		System.out.println(productDetails);
	}
	
	@Around("execution(public void setName*(..))") //* setName*(..)
	public void aroundProduct(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("====> Around product ++++==========<");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(methodSignature);
		long begin = System.currentTimeMillis();		
		// now, let's execute the method
		Object result = joinPoint.proceed();		
		// get end timestamp
		long end = System.currentTimeMillis();
		// compute duration and display it
		long duration = end - begin;
		System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");
	}
}
