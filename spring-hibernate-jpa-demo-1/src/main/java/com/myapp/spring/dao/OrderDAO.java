package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.hibernate.model.Order;

public interface OrderDAO {

	
	List<Order> findAll();
	
	void save (Order order);
}
