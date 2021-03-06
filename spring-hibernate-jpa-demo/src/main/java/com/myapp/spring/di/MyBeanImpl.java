package com.myapp.spring.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype") // this will cause myBean==myBean to return false..// it
// will clone the previous object & give new reference which results in false
// ...which signifies it is not singleton(now) it is prototype pattern...N
// This will result in init to called three times)

@Scope("singleton") // This will result in init to called one times)
public class MyBeanImpl implements MyBean {

	// @Autowired
	// @Qualifier("instance2") // autowiring by the use name // TwoImpl of one
	// interface & hence ambiguity , so thats y we need to use Qualifier
	private GreetingBean greetingBean;

	@PostConstruct
	public void initialize() {
		System.out.println("------------------------------------------");
		System.out.println("Inside Init");
		System.out.println("------------------------------------------");
	}

	// testing autowiring by constructor
	@Autowired
	public MyBeanImpl(@Qualifier("instance2") GreetingBean greetingBean) {
		super();
		this.greetingBean = greetingBean;
	}

	@Override
	public String display() {

		return greetingBean.greeting();
	}

	@PreDestroy  // container Destroys only singleton beans.. if its prototype then then container will ignore
	public void destroy() {
		System.out.println("------------------------------------------");
		System.out.println("Destroy");
		System.out.println("------------------------------------------");
	}

}
