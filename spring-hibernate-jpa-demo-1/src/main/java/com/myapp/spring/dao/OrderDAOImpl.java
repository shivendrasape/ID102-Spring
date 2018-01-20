package com.myapp.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.hibernate.model.Order;

@Repository // Instead of component annotation
public class OrderDAOImpl implements OrderDAO {

	@PersistenceContext // Applicable only for em not for other objects
	private EntityManager em;

	@Override
	public List<Order> findAll() {

		return em.createQuery("from Order").getResultList();
	}

	@Override
	@Transactional 												// select it from spring
	public void save(Order order) {

		em.persist(order);
		em.merge(order);
	}

}
