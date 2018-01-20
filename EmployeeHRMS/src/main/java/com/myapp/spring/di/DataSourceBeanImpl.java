package com.myapp.spring.di;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DataSourceBeanImpl implements DataSourceBean {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
