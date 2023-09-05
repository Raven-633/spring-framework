package org.springframework.aop.aspectj.annotationAspect;

import org.springframework.stereotype.Component;

/**
 * @author Ds
 */
@Component
public class AnTarget {

	public void aspectTest(){
		System.out.println("执行aspectTest...");
	}

}