package com.myapp.spring.config;

import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = "com.myapp.spring") // Search for class who is component
public class AppConfig {
	@Bean
	public Date date() {
		return new Date();
	}
	@Bean
	public Date date1() {
		return new Date();
	}
	@Bean
	public Calendar calendar() {
		return Calendar.getInstance();
	}
	
	@Bean
	public DataSource dataSource() { // DataSource from Sql

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/hibernatespring");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		return dataSource;

	}
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		
		return new JdbcTemplate(dataSource);
		
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
		//single thread to schedule the task
		return new ConcurrentTaskScheduler();
	} 

}