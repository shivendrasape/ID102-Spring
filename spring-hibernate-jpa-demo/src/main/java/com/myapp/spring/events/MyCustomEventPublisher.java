package com.myapp.spring.events;

import java.util.Date;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component //Spring Managed bean
public class MyCustomEventPublisher implements ApplicationEventPublisherAware {

	protected ApplicationEventPublisher aea;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher aea) {
		
		this.aea=aea;
	}
	
	@Scheduled(fixedRate=3000L)  // used for periodically publishing events after 3 sec
	public void PublishEvents() {
		
		final Date date=new Date();
		final MyCustomEvent event=new MyCustomEvent(this, date.toString()); // this represents publisher object
		System.out.println("---------------------------");
		aea.publishEvent(event);
		System.out.println("---------------------------");
		
	}
	
	@Scheduled(fixedRate=1000L)  // used for periodically publishing events after 3 sec
	public void PublishEvents1() {
		
		final MyCustomEvent event=new MyCustomEvent(this, "fgdg"); // this represents publisher object
		
		//The argument will passes as the event in EventSubcriber
		System.out.println("---------------------------");
		aea.publishEvent(event);
		System.out.println("---------------------------");
		
	}
	
}