package com.hibernate.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import com.hibernate.jpa.entity.Customer;

public interface CustomerRepository {
	
	void save(Customer customer);
	
	void update(Customer customer);
	
	Customer find(long id);
	
	List<Customer> findAll();
	
	void setEntityManager(EntityManager entityManager);
	
}
