package com.hibernate.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.jpa.entity.Order;

public class OrderRepositoryImpl implements OrderRepository {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(Order order) {

		EntityTransaction trxn = entityManager.getTransaction();
		try {
			trxn.begin();
			entityManager.persist(order);
			trxn.commit();
		} catch (Exception e) {
			trxn.rollback();
			e.printStackTrace();
		}

	}

	public void update(Order order) {

		EntityTransaction trxn = entityManager.getTransaction();
		try {
			trxn.begin();
			entityManager.merge(order);
			trxn.commit();
		} catch (Exception e) {
			trxn.rollback();
			e.printStackTrace();
		}

	}

	public Order findById(long id) {

		return entityManager.find(Order.class, id);
	}

	public void delete(long id) {
		EntityTransaction trxn = entityManager.getTransaction();
		try {
			trxn.begin();
			entityManager.remove(entityManager.find(Order.class, id));
			trxn.commit();
		} catch (Exception e) {
			trxn.rollback();
			e.printStackTrace();
		}

	}

	public List<Order> findAll() {

		return entityManager.createQuery("from Order").getResultList();  //JpQL is used
	}

}
