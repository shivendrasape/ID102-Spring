package com.myapp.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.di.DataSourceBean;

public class TestSpringJdbcTemplate {

	public static void main(String[] args) {

		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);

		FlightDAO dao= springContainer.getBean(FlightDAO.class);
		
	//	FlightDAOImpl dao= springContainer.getBean(FlightDAOImpl.class);
		
		
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		dao.findAll().forEach(System.out::println);
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");

		springContainer.close();

	}

}
