package com.myapp.jsm.reciever;

import java.io.IOException;

import com.myapp.jsm.utils.ExchangeQueueUtils;
import com.myapp.jsm.utils.RabbitMQConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class FanoutSubscriber {

	public static void main(String[] args) {
		
		
		Connection connection=RabbitMQConnection.getConnection();
		
		if(connection!=null) {
			try {
				Channel channel =connection.createChannel();
		
				Consumer consumer1=new DefaultConsumer(channel) {
					@Override	
					public void handleDelivery(String consumerTag, Envelope envelope, 
							BasicProperties properties,
							byte[] body) throws IOException {
						
						String message = new String(body,"UTF-8");
						System.out.println("Consumer Tag "+consumerTag);
						System.out.println("Consumer Tag "+envelope.getExchange());
						System.out.println("Basic properties "+properties.getContentType()+" "+ properties.getMessageId());
						System.out.println("Message Receievd from Queue A "+message);
						
						
					}
				};
				channel.basicConsume(ExchangeQueueUtils.QUEUE_A, consumer1);
				

				
				Consumer consumer2=new DefaultConsumer(channel) {
					@Override	
					public void handleDelivery(String consumerTag, Envelope envelope, 
							BasicProperties properties,
							byte[] body) throws IOException {
						
						String message = new String(body,"UTF-8");
						System.out.println("Consumer Tag "+consumerTag);
						System.out.println("Consumer Tag "+envelope.getExchange());
						System.out.println("Basic properties "+properties.getContentType()+" "+ properties.getMessageId());
						System.out.println("Message Receievd from Queue B "+message);
						
						
					}
				};
				channel.basicConsume(ExchangeQueueUtils.QUEUE_B, consumer2);
				
			
				
				Consumer consumer3=new DefaultConsumer(channel) {
					@Override	
					public void handleDelivery(String consumerTag, Envelope envelope, 
							BasicProperties properties,
							byte[] body) throws IOException {
						
						String message = new String(body,"UTF-8");
						System.out.println("Consumer Tag "+consumerTag);
						System.out.println("Consumer Tag "+envelope.getExchange());
						System.out.println("Basic properties "+properties.getContentType()+" "+ properties.getMessageId());
						System.out.println("Message Receievd from Queue C "+message);
						
						
					}
				};
				channel.basicConsume(ExchangeQueueUtils.QUEUE_C, consumer3);
				
				channel.close();
				connection.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
