package com.myapp.hibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.myapp.hibernate.model.CD;

public class TestCDQuery {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHIBERNATE");

		EntityManager em = emf.createEntityManager();
		
	    CD	cd=em.find(CD.class,6L );
		System.out.println(cd);
		cd.getMusicians().forEach(System.out::println);

		em.close();

		emf.close();

	}

}
