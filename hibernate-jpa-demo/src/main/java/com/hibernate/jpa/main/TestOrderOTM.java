package com.hibernate.jpa.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hibernate.jpa.dao.CustomerRepositoryImpl;
import com.hibernate.jpa.entity.Customer;
import com.hibernate.jpa.entity.Order;
import com.hibernate.jpa.util.HibernateJpaUtility;

public class TestOrderOTM {

	public static void main(String[] args) {
		
		
	CustomerRepositoryImpl customerRepository=new CustomerRepositoryImpl();
	customerRepository.setEntityManager
	(HibernateJpaUtility.getFactory().createEntityManager());

	
	Customer customer1=new Customer("Shivendra","Gupta","sgupta227@sapient.com"); 
	
	Order order1=new Order("G123",new Date(),new Date(),"NEW");
	order1.setCustomer(customer1);
	Order order2=new Order("H123",new Date(),new Date(),"NEW");
	order2.setCustomer(customer1);
	Order order3=new Order("I123",new Date(),new Date(),"NEW");
	order3.setCustomer(customer1);

	
	Set<Order> orders= new HashSet<>();
	orders.add(order1);
	orders.add(order2);
	orders.add(order3);
	
	// orders has 3 orders
	customer1.setOrders(orders);// customer1 has orders
	customerRepository.save(customer1);
	
	customerRepository.findAll().forEach(System.out::println);
	HibernateJpaUtility.closeEntityManagerfactory();

	
	}

}
