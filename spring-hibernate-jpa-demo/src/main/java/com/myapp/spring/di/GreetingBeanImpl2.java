package com.myapp.spring.di;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("instance2")
public class GreetingBeanImpl2 implements GreetingBean {

	@Autowired
	private Date date;
	
	@Autowired
	private Calendar calendar;
	
	// We have instantiated  the Date & calender
	@Override
	public String greeting() {
		// TODO Auto-generated method stub
		
		int hour = calendar.get(Calendar.HOUR_OF_DAY);	
		return (hour<12)?"Good Mrng":"Good  Afternoon"+date;
	}

}
