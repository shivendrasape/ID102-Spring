package com.hibernate.jpa.main;

import java.time.Instant;
import java.util.Date;

import com.hibernate.jpa.dao.OrderRepositoryImpl;
import com.hibernate.jpa.entity.Order;
import com.hibernate.jpa.util.HibernateJpaUtility;

public class TestOrder {

	public static void main(String[] args) {
		
		
	OrderRepositoryImpl orderRepository=new OrderRepositoryImpl();
	orderRepository.setEntityManager
	(HibernateJpaUtility.getFactory().createEntityManager());

	Order order1=new Order("C123",new Date(),new Date(),"NEW");
//	orderRepository.save(order1);
	
	Order order=orderRepository.findById(17L);
	order.setLastUpdate(Date.from(Instant.now().plusSeconds(500000)));
	order.setStatus("PROCESSING");
	
	 orderRepository.update(order);
	
    //	System.out.println(orderRepository.findAll());
	
    //	orderRepository.delete(1L);
	
	
	
	orderRepository.findAll().forEach(System.out::println);
		
	HibernateJpaUtility.closeEntityManagerfactory();
	}

}
