package com.myapp.hibernate.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.myapp.hibernate.model.Order;

public class TestJPQL {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHIBERNATE");

		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("orderFindByStatus");
		query.setParameter("STATUS", "NEW");
		query.getResultList().forEach(System.out::println);

		TypedQuery<Order> query1 = em.createNamedQuery("orderFindByStatus", Order.class);// Search is narrowed down ( of
																							// query ) & also type
																							// safety is maintained
		query1.setParameter("STATUS", "NEW");
		query1.getResultList().forEach(System.out::println);

		TypedQuery<Order> query2 = em.createNamedQuery("orderFindByOrderPlacedDate", Order.class);// Search is narrowed
																									// down ( of query )
																									// & also type
																									// safety is
																									// maintained
		query2.setParameter("TIMEPLACED", new Date());
		query2.getResultList().forEach(System.out::println);

		TypedQuery<Order> query3 = em.createNamedQuery("orderFindByOrder", Order.class);// Search is narrowed down ( of
																						// query ) & also type safety is
																						// maintained
		query3.setParameter(0, "NEW");
		query3.getResultList().forEach(System.out::println);

		System.out
				.println("//Criteria API { criteria Query } ( pure OO ) & we are not using annotations (named query)");
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery();
		Root<Order> root = cq.from(Order.class);
		Predicate pctStatus = cb.equal(root.get("status"), "NEW");
		cq.where(pctStatus);
		cq.select(root);

		em.createQuery(cq).getResultList().forEach(System.out::println);

		em.close();
		emf.close();

	}

}
