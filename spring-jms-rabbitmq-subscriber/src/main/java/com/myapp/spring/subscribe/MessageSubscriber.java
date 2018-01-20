package com.myapp.spring.subscribe;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.myapp.spring.conifg.RabbitMQConfig;

@Component
public class MessageSubscriber {
	
	
	@RabbitListener(queues=RabbitMQConfig.queueName)
	public void subscriber(Map<String, Object> message) {
		System.out.println("**********Message Received************"+message);
		
	}
	
	
	

}
