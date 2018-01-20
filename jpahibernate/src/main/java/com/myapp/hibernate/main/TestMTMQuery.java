package com.myapp.hibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.myapp.hibernate.model.Benefit;
import com.myapp.hibernate.model.CD;
import com.myapp.hibernate.model.Employee;
import com.myapp.hibernate.model.Flight;
import com.myapp.hibernate.model.Musician;

public class TestMTMQuery {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHIBERNATE");

		EntityManager em = emf.createEntityManager();
	
		em.find(Benefit.class, 39L).getEmployees().values().forEach(System.out::println);

		em.close();

		emf.close();

	}

}
