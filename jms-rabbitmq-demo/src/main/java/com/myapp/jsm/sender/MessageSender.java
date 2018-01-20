package com.myapp.jsm.sender;

import java.io.IOException;
import java.util.Date;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MessageSender {

	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory= new ConnectionFactory();
		connectionFactory.setHost("localhost");
		
		Connection connection=null;
		try {
			 connection= connectionFactory.newConnection();
			Channel channel=connection.createChannel();
					channel.queueDeclare("MyQueue",false,false,false,null);
					
				// channel is the pipeline to push the messages	
					channel.basicPublish("", "MyQueue", null,
							new Date().toString().getBytes("UTF-8"));
					
					
				
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	}


