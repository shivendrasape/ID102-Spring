package com.myapp.spring.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component //Spring Managed bean
public class MyCustomEventSubscriber {

	@EventListener({MyCustomEvent.class}) // curly braces-> arrays so it can listen to any no of events
	public void handleChangeEvents(final MyCustomEvent event) {  // Subscriber is not responsible for making change & hence final is used
		
		System.out.println("Event Received"+ event.getMessage());
		
	}
	
}
