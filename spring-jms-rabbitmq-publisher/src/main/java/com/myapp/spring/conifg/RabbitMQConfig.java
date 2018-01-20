package com.myapp.spring.conifg;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	// creation of connection factory is not mandatory in spring boot
	public ConnectionFactory connectionFactory() {

		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

		connectionFactory.setHost("localhost");
		return connectionFactory;

	}

	@Bean
	public RabbitTemplate rabbitTemplate() {

		return new RabbitTemplate(connectionFactory());
	}

	public final static String queueName = "spring-queue";
	public final static String exchangeName = "spring-exchange";
	
	@Bean
	public Queue queue() {
		return new Queue(queueName,false);
		
	}
	
	@Bean
	public Exchange exchange() {
		return new DirectExchange(exchangeName);
		
	}
	@Bean
	@Autowired
	public Binding binding(Queue queue,DirectExchange exchange) {
			
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
		
		
	}

}
