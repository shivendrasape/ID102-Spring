package com.hibernate.jpa.dao;

import java.util.List;

import com.hibernate.jpa.entity.Order;

public interface OrderRepository {

	
void save(Order order);

void update(Order order);

Order findById(long id);

void delete(long id);

List<Order> findAll();



}
