package com.myapp.jsm.sender;

import java.io.IOException;

import com.myapp.jsm.utils.ExchangeQueueUtils;
import com.myapp.jsm.utils.RabbitMQConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class FanoutSender {

	public static void main(String[] args) {
		
		Connection connection=RabbitMQConnection.getConnection();
		ExchangeQueueUtils utils=new ExchangeQueueUtils();
		utils.createQueueAndExchange();
		
		if(connection!=null) {
			
			try {
				Channel channel=connection.createChannel();
				channel.basicPublish(ExchangeQueueUtils.EXCHANGE_NAME, "", null, "Fanout Message".getBytes());
				channel.close();
				connection.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
