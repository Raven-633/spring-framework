package org.springframework.aop.aspectj;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.aop.aspectj.annotationAspect.AnTarget;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Ds
 */
public class AnnotationAspectTest {

	private AnnotationConfigApplicationContext ctx;


	@BeforeEach
	void setup() throws Exception {
		this.ctx = new AnnotationConfigApplicationContext("org.springframework.aop.aspectj.annotationAspect");
	}

	@Test
	public void befroreTest(){
		AnTarget anTarget = ctx.getBean(AnTarget.class);
		anTarget.aspectTest();
	}

}