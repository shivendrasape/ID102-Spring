package com.myapp.spring.publsiher;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.conifg.RabbitMQConfig;

@RestController
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate template;    // 
	
	
	@GetMapping("/sender/{msg}")   // getMapping // postmapping   // 
	public String sendMessage(@PathVariable("msg")String message) {
		
		Map<String, Object> objectmessage=new HashMap<>();
		
		objectmessage.put("message",message);
		template.convertAndSend(RabbitMQConfig.queueName,objectmessage);
		
		return "Meessage Send To Queue";
		
	}
	
	
}
