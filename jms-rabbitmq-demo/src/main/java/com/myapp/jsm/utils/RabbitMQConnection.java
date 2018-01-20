package com.myapp.jsm.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQConnection {

	public static Connection getConnection() {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");

		Connection connection = null;
		try {
			connection = connectionFactory.newConnection();

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return connection;

	}
}
