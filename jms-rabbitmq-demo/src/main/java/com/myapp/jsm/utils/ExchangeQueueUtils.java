package com.myapp.jsm.utils;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class ExchangeQueueUtils {

	public static final String EXCHANGE_NAME="my-fanout-exchange";
	
	public static final String QUEUE_A="my-fanout-queue-A";
	public static final String QUEUE_B="my-fanout-queue-B";
	public static final String QUEUE_C="my-fanout-queue-C";
	
	
	public void createQueueAndExchange() {
		
		Connection connection =RabbitMQConnection.getConnection();
		
		if(connection!=null) {
			
			try {
				Channel channel=connection.createChannel();
				channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
				
				channel.queueDeclare(QUEUE_A,true,false,false,null);
				channel.queueBind(QUEUE_A,EXCHANGE_NAME,"");
				
				channel.queueDeclare(QUEUE_B,true,false,false,null);
				channel.queueBind(QUEUE_B,EXCHANGE_NAME,"");
				
				channel.queueDeclare(QUEUE_C,true,false,false,null);
				channel.queueBind(QUEUE_C,EXCHANGE_NAME,"");
				
				
				channel.close();
				connection.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
