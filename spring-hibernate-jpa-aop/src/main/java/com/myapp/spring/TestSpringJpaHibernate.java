package com.myapp.spring;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.aop.LoginManagerBean;
import com.myapp.spring.config.AppConfig;
import com.myapp.spring.dao.OrderDAO;
import com.myapp.spring.hibernate.model.Customer;
import com.myapp.spring.hibernate.model.Order;

public class TestSpringJpaHibernate {

	public static void main(String[] args) {

		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);

		LoginManagerBean loginManagerBean=springContainer.getBean(LoginManagerBean.class);
		
		loginManagerBean.login("admin", "");
		
		OrderDAO orderDao = springContainer.getBean(OrderDAO.class);
		orderDao.findAll().forEach(System.out::println);

		Order order = new Order("K123", new Date(), new Date(), "NEW");

		Customer customer1 = new Customer("abcd", "Afcdv", "svsvfv@gmail.com");
		order.setCustomer(customer1);
		orderDao.save(order);

		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");

		// springContainer.close();
		// we are not closing the conatiner otherwise only one timw event will be
		// published
	}

}
