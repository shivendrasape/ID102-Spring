package com.myapp.spring.config;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.myapp.spring") // Search for class who is component

@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

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
	public Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.cache.use_second_level_cache", "true");
		properties.put("hibernate.cache.use_query_cache", "true");
		properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		return properties;
	}

	// Spring Provide class & implements EMF of JPA

	@Bean(name = "entityManagerFactory")
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(

		DataSource dataSource, Properties jpaProperties) {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
        // class which is wrapper given by spring
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("com.myapp.spring.hibernate.model");
		emf.setJpaProperties(jpaProperties);
		emf.setPersistenceUnitName("Default");	
		emf.afterPropertiesSet();
		
		return emf;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

		//PlatformTransactionManager is an interface
		//JpaTransactionManager is an aspect class
		// emf is getting injected... with hibernate hibernateTransaction manager is used..with jpa .. Jpa Transaction manger is used
		// if we use Jdbc template then we have to use Jdbc Transaction manager
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		converters.add(new MappingJackson2HttpMessageConverter()); // lib for serializing & deserializing
		super.configureMessageConverters(converters);
	}
	
	// Autowiring first takes place by name first & then it checks for the type
}
