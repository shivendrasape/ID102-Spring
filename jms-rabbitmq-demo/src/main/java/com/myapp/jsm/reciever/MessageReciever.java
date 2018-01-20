package com.myapp.jsm.reciever;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class MessageReciever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");

		try {
			Connection connection = connectionFactory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare("MyQueue", false, false, false, null);

			channel.exchangeDeclare("MyExchange", "direct");
			channel.queueBind("MyQueue", "MyExchange", "");

			QueueingConsumer consumer = new QueueingConsumer(channel);
			channel.basicConsume("MyQueue", true, consumer);

			while (true) {

				QueueingConsumer.Delivery delivery = consumer.nextDelivery();
				String message = new String(delivery.getBody());
				System.out.println("Messsage Received " + message);

			}

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ShutdownSignalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConsumerCancelledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
