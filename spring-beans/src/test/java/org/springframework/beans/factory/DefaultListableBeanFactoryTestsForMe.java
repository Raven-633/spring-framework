package org.springframework.beans.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ds
 */
public class DefaultListableBeanFactoryTestsForMe {

	private DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();


	@Test
	void InstantiationAwareBeanPostProcessorTest() {
		lbf.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		lbf.registerBeanDefinition("test1", new RootBeanDefinition(Test1.class));
		Test1 test1 = lbf.getBean(Test1.class);
		assertThat(test1.desc.equals("postProcessBeforeInstantiation")).isTrue();
	}

	static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
		@Override
		public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
			if (beanClass.equals(Test1.class)) {
				return new Test1("postProcessBeforeInstantiation");
			}
			return null;
		}
	}

	static class Test1 {
		private String desc;

		public Test1() {
		}

		public Test1(String desc) {
			this.desc = desc;
		}
	}


}