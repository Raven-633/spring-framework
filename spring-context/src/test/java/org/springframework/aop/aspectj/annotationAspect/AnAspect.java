package org.springframework.aop.aspectj.annotationAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Ds
 */
@Aspect
@Component
public class AnAspect {

	@Pointcut("execution(* *(*))")
	public void pointcut() {

	}

	@Before("pointcut()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("方法执行前进行了一些操作");
	}

}