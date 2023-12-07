package org.springframework;

import org.junit.Test;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 基于注解的BeanFactory测试
 * 1. 如何解析类中的bean信息
 * 2.
 *
 * @author Ds
 */
public class AnnoBeanFactoryTest {

	@Test
	public void test1() {

		AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(Test2.class);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerBeanDefinition("test2", annotatedGenericBeanDefinition);
	}

	@Component
	public static class Test2 {

	}

}