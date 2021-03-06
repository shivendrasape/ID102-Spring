package com.myapp.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.di.GreetingBean;
import com.myapp.spring.di.GreetingBeanImpl;

public class TestSpringDI {

	public static void main(String[] args) {

		// Step 1. Start the spring container

		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);

		// Step2 request for bean inside the spring container

		//GreetingBean greetingBean = springContainer.getBean("greetingBeanImpl2",GreetingBean.class);
		
		
		GreetingBean greetingBean = springContainer.getBean("instance1",GreetingBean.class);
		
		

	//	GreetingBeanImpl greetingBean = springContainer.getBean(GreetingBeanImpl.class);
		
		System.out.println("------------------------------------------");
		System.out.println(greetingBean.greeting());
		System.out.println("------------------------------------------");

		// Step3 Close the container { otherwise jvm keeps container }
		springContainer.close();

	}

}
