package com.myapp.spring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.config.AppConfig;
import com.myapp.spring.di.DataSourceBean;

public class TestSpringDI3 {

	public static void main(String[] args) {

		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);

		DataSourceBean dataSourceBean = springContainer.getBean(DataSourceBean.class);

		try(Connection connection = dataSourceBean.getConnection()){
	     String sql ="select * from my_orders";
	     
	     try(Statement statement = connection.createStatement()){
	    	 
	    	 ResultSet rs =statement.executeQuery(sql);
	    	 while(rs.next()) {
	    		 System.out.println(rs.getLong(1)+" "+rs.getString(2));
	    	 }
	     }
		
		}
		
		catch(SQLException e) {
				e.printStackTrace();
			}
		
		
		System.out.println("------------------------------------------");
		System.out.println(dataSourceBean.getConnection());
		System.out.println("------------------------------------------");

		springContainer.close();

	}

}
