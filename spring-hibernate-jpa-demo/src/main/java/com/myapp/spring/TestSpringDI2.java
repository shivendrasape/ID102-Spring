package com.myapp.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.di.GreetingBean;
import com.myapp.spring.di.GreetingBeanImpl;
import com.myapp.spring.di.MyBean;

public class TestSpringDI2 {

	public static void main(String[] args) {

		// Step 1. Start the spring container

		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);

		// Step2 request for bean inside the spring container

		// GreetingBean greetingBean =
		// springContainer.getBean("greetingBeanImpl2",GreetingBean.class);

		MyBean myBean = springContainer.getBean(MyBean.class);

		MyBean myBean1 = springContainer.getBean(MyBean.class);

		MyBean myBean2 = springContainer.getBean(MyBean.class);
	

		// GreetingBeanImpl greetingBean =
		// springContainer.getBean(GreetingBeanImpl.class);

		System.out.println("*********" + (myBean == myBean1));
		System.out.println("------------------------------------------");
		System.out.println(myBean.display());
		System.out.println("------------------------------------------");

		// Step3 Close the container { otherwise jvm keeps container }
		springContainer.close();

	}

}
