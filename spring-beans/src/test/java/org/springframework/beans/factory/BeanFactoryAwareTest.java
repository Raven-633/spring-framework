package org.springframework.beans.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import static org.junit.jupiter.api.Assertions.*;

class BeanFactoryAwareTest {

	static class TestBeanFactoryAware implements BeanFactoryAware {
		@Override
		public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
			System.out.println("[TestBeanFactoryAware] " + beanFactory.getBean(TestBeanFactoryAware.class).getClass().getSimpleName());
		}
	}

	@Test
	void setBeanFactoryTest() {
		RootBeanDefinition beanDefinition = new RootBeanDefinition(TestBeanFactoryAware.class);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerBeanDefinition("TestBeanFactoryAware", beanDefinition);
		assertNotNull(beanFactory.getBean("TestBeanFactoryAware"));
	}
}